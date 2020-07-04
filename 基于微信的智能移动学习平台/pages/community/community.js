// pages/community/community.js
var util = require("../../utils/util.js");
Page({

  /**
   * 页面的初始数据
   */
  data: {
    questioner:[],
    user_Info:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    //this.getData();
    wx.request({
      url: 'http://localhost:8888/web_war_exploded/community',
      method:"GET",
      data : {
        type:"community"
      },
      header: {
        'Content-Type': 'application/json'
      },
      success: function(res) {
        that.setData({
          questioner:res.data
        })
        console.log(res.data);
      },
      fail:function(res){
        that.setData({
          questioner :res.data
        })
      }
    })
  },

  getData:function () {
    var questioner = util.getData2().data;
    console.log(questioner);
    this.setData({questioner:questioner})
  },
  change:function(event){
    var that = this;
    var name;
    wx.request({
      url: 'http://localhost:8888/web_war_exploded/community',
      method:'GET',
      data : {
        name:event.detail.value,
        type:"searchResult"
      },
      header: {
        'Content-Type': 'application/json'
      },
      success: (res) => {
        that.setData({
          questioner: res.data
        })
        console.log(res.data);
        console.log(that.data.questioner)
      },
      fail: function() {
        console.log('error');
      }
    })
  },
  createDis:function(event){
    var that = this;
    wx.getUserInfo({
      success: (res) => {
        wx.request({
          url: 'http://localhost:8888/web_war_exploded/community',
          method:"GET",
          data : {
            type:"createDisRequest",
            user_name:res.userInfo.nickName
          },
          header:{
            'Content-Type': 'application/json'
          },
          success:function(res){
            that.setData({
              user_Info:res.data
            })
            console.log(res.data)
            console.log(that.data.user_Info[0].user_isBan)
            if(that.data.user_Info[0].user_isBan == false){
              wx.redirectTo({
                url: '/pages/dislaunch/dislaunch',
              })
             }
             else{
               wx.showModal({
                title: '提示',
                content: '您已被禁言，请向管理员申请解除禁言',
               })
             }
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