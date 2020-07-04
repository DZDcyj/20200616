// pages/course/course.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    currentTab :0,
    navbar : ['我发布的课程','我学的课程']
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
            url: 'http://localhost:8888/web_war_exploded/course',
            method:'GET',
            data : {
              name: res.userInfo.nickName,
              type:"myCourse_teach"
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

  },
  navbarTap: function(e){
    var that = this;
    this.setData({
      currentTab: e.currentTarget.dataset.idx
    })
    console.log(this.data.currentTab)
    if(this.data.currentTab == 0){
      console.log("进入教授")
    //获取用户信息
    wx.getUserInfo({
        success: function (res) {
          wx.request({
            url: 'http://localhost:8888/web_war_exploded/course',
            method:'GET',
            data : {
              name: res.userInfo.nickName,
              type:"myCourse_teach"
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
    }
    if(this.data.currentTab == 1){
    //获取用户信息
    console.log("进入学习")
    wx.getUserInfo({
        success: function (res) {
          wx.request({
            url: 'http://localhost:8888/web_war_exploded/course',
            method:'GET',
            data : {
              name: res.userInfo.nickName,
              type:"myCourse_learn"
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
    }
  },
  change:function(event){
    var that = this;
    var name;
    wx.getUserInfo({
     success: (res) => {
      wx.request({
        url: 'http://localhost:8888/web_war_exploded/course',
        method:'GET',
        data : {
          name:res.userInfo.nickName,
          input:event.detail.value,
          type:"searchResult",
          course_num:that.data.currentTab
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
  }
})