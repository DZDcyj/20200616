// pages/deletemycourse/deletemycourse.js
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
    //获取用户信息
    wx.getUserInfo({
        success: function (res) {
          wx.request({
            url: 'http://localhost:8888/web_war_exploded/deletecourse',
            method:'GET',
            data : {
              user_name:res.userInfo.nickName,
              type:"initMy"
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
  delete:function(event){
    var that = this;
    //获取用户信息
    wx.getUserInfo({
        success: function (res) {
          wx.request({
            url: 'http://localhost:8888/web_war_exploded/deletecourse',
            method:'GET',
            data : {
              user_name:res.userInfo.nickName,
              id:event.currentTarget.dataset.id,
              type:"deletemycourse"
            },
            header: {
              'Content-Type': 'application/json'
            },
            success: (res) => {
              that.setData({
                arrays: res.data
              })
              wx.reLaunch({
                url: '/pages/account/account',
              })
              wx.switchTab({
                url: '/pages/account/account',
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