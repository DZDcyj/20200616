// pages/videoplayer/videoplayer.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    id:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    var nickName;
    this.setData({
      id:options.id
    })
    wx.getUserInfo({
      success: function(res) {
        wx.request({
          url: 'http://localhost:8888/web_war_exploded/course',
          method:'GET',
          data : {
            name: res.userInfo.nickName,
            id:that.data.id,
            type: "video"
          },
          header: {
            'Content-Type': 'application/json'
          },
          success: (res) => {
            that.setData({
               arrays: res.data
            })
            console.log(res.data);
          },
          fail: function() {
            console.log('error');
          }
        })
      }
    })
    
  },
  clickAdd:function(event){
      var that = this;
      var nickName;
      wx.getUserInfo({
        success: function(res) {
          wx.request({
            url: 'http://localhost:8888/web_war_exploded/course',
            method:'GET',
            data : {
              user_name:res.userInfo.nickName,
              course_id:event.currentTarget.dataset.course_id,
              type: "addVideo"
            },
            header: {
              'Content-Type': 'application/json'
            },
            success: (res) => {
              console.log(res.data);
              wx.showToast({
                title: '加入成功',
              })
            },
            fail: function() {
              console.log('error');
            }
          })
        }
      })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})