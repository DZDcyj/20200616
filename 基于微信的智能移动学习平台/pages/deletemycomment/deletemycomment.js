// pages/deletemycomment/deletemycomment.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getUserInfo({
      success: (res) => {
        wx.request({
          url: 'http://localhost:8888/web_war_exploded/deletecomment',
          method:"GET",
          data:{
            user_name:res.userInfo.nickName,
            type:"initMy"
          }, 
          header: {
            'Content-Type': 'application/json'
          },
          success: function(res) {
            that.setData({
              comment:res.data
            })
            console.log(res.data)
          }
        })
      },
    })
  },
  delete:function(event){
    console.log("删除的id为");
    console.log(event.currentTarget.dataset.id);
    
    var that = this;
    wx.getUserInfo({
      success: (res) => {
    
        wx.request({
          url: 'http://localhost:8888/web_war_exploded/deletecomment',
          method:"GET",
          data:{
            responder:event.currentTarget.dataset.responder,
            id:event.currentTarget.dataset.id,
            type:"delete"
          }, 
          header: {
            'Content-Type': 'application/json'
          },
          success: function(res) {
            that.setData({
              comment:res.data
            })
            console.log(res.data)
            wx.reLaunch({
              url: '/pages/deletemycomment/deletemycomment',
            })
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