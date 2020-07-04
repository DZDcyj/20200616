// pages/upban/unban.js
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
          url: 'http://localhost:8888/web_war_exploded/ban',
          method:"GET",
          data:{
            name:res.userInfo.nickName,
            type:"initUnBanPage"
          }, 
          header: {
            'Content-Type': 'application/json'
          },
          success: function(res) {
            that.setData({
              users:res.data
            })
            console.log(res.data)
          }
        })
      }
    })
  },
  unban:function(event){
    var that = this;
    wx.getUserInfo({
      success: (res) => {
        wx.request({
          url: 'http://localhost:8888/web_war_exploded/ban',
          method:"GET",
          data:{
            name:event.currentTarget.dataset.name,
            type:"unbanUser"
          }, 
          header: {
            'Content-Type': 'application/json'
          },
          success: function(res) {
            that.setData({
              users:res.data
            })
            console.log(res.data)
            wx.reLaunch({
              url: '/pages/unban/unban',
            })
          }
        })
      },
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