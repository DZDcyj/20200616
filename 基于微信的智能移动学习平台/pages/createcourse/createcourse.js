// pages/createcourse/createcourse.js
const app = getApp()
const uploadImage = require('../utils/uploadFile.js');
const util = require('../utils/util.js');
let content=''
Page({

  /**
   * 页面的初始数据
   */
  data: {
    title:"",
    img_url:"",
    video_url:"",
    description:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.getUserInfo({
      success: (res) => {
        wx.request({
          url: 'http://localhost:8888/web_war_exploded/createCourse',
          method:"GET",
          data:{
            type:"init"
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
  getContent(event){
    content = event.detail.value
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
  getTitle:function(event){
    this.setData({
      title:event.detail.value
    })
  },
  getDescription:function(event){
    this.setData({
      description:event.detail.value
    })
  },
  send:function(event){
    var that = this;
    if(content.length<1){
      wx.showToast({
        icon:'none',
        title: '请填写课程名称',
      })
      return
    }
    
    wx.getUserInfo({
      success: (res) => {
        wx.request({
          url: 'http://localhost:8888/web_war_exploded/createCourse',
          method:"GET",
          data : {
            type:"createCourse",
            title:that.data.title,
            img_url:that.data.img_url,
            video_url:that.data.video_url,
            description:that.data.description,
            user_name:res.userInfo.nickName
          },
          header: {
            'Content-Type': 'application/json'
          },
          success : function(res){
            setTimeout(function() {
              //要延时执行的代码
              wx.showToast({
                title: '创建成功',
              })
            }, 1000)
            
            wx.reLaunch({
              url: '/pages/home/home',
            })
          }
        })
      },
    })
  },
  chooseimage:function(e){
    var that = this;
    wx.chooseImage({
      count: 1,
      sizeType: ['compressed'],
      sourceType: ['album'],
      success: function(result) {
        console.log('chooseImage success ,temp path is',result.tempFilePaths[0])

        var imageSrc = result.tempFilePaths[0]
        var nowTime = util.formatTime(new Date());

          uploadImage(result.tempFilePaths[0],'images/',
          function(result){
            console.log("success",result);
            wx.showToast({
              title: '正在上传',
              icon:"loading",
              duration:2000,
            })
            //wx.hideLoading();
            that.setData({
              img_url:result
            })
              wx.hideLoading()
          },function (result){
            console.log("fail",result);
            wx.hideLoading();
          }
          )
      },
    })
  },
  choosevideo:function(e){
    var that = this;
    wx.chooseVideo({
      count: 1,
      sourceType: ['album'],
      success: function(result) {
        console.log('chooseVideo success ,temp path is',result.tempFilePath)

        var imageSrc = result.tempFilePath
        var nowTime = util.formatTime(new Date());

          uploadImage(result.tempFilePath,'video/',
          function(result){
            wx.showToast({
              title: '正在上传',
              icon:"loading",
              duration:2000,
            })
            console.log("success",result);
            that.setData({
              video_url:result
            })
              wx.hideLoading();
          },function (result){
            console.log("fail",result);
            wx.hideLoading();
          }
          )
      },
    })
  },
})

