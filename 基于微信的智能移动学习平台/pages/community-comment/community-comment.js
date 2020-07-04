// pages/community-comment/community-comment.js
var util = require("../../utils/util.js");
let content=''
Page({

  /**
   * 页面的初始数据
   */
  data: {
    questioner:[],
    comment:[],
    question_id:0,
    comment_input:0,
    user_info:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    this.getData();
    console.log("---question_id---"+options.question_id) ;
    this.setData({question_id:options.question_id});
    wx.request({
      url: 'http://localhost:8888/web_war_exploded/community',
      method:"GET",
      data:{
        discussion_id:that.data.question_id,
        type:"comment"
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
  getData:function () {
   /* var that = this;
    var questioner = util.getData2().data;
    console.log(questioner);
    this.setData({questioner:questioner})

    var comment = util.getData3().data;
    console.log(comment);
    this.setData({comment:comment})*/
    /**
     * 刘子聿修改
     */
    var that = this;
    wx.request({
      url: 'http://localhost:8888/web_war_exploded/community',
      method:"GET",
      data:{
        discussion_id:that.data.question_id,
        type:"community"
      }, 
      header: {
        'Content-Type': 'application/json'
      },
      success: function(res) {
        that.setData({
          discussions:res.data
        })
        console.log(res.data)
      }
    })
  },

  send:function(event){
    var that = this;
    if(content.length<4){
      wx.showToast({
        icon:'none',
        title: '评论太短了',
      })
      return
    }
    wx.getUserInfo({
      success: (res) => {
        var res_info = res;
        wx.request({
          url: 'http://localhost:8888/web_war_exploded/community',
          method:"GET",
          data:{
            user_name:res.userInfo.nickName,
            type:"send"
          }, 
          header: {
            'Content-Type': 'application/json'
          },
          success: function(res) {
            that.setData({
              user_info:res.data
            })
            if(that.data.user_info[0].user_isBan == false){
              wx.request({
                url: 'http://localhost:8888/web_war_exploded/community',
                method:"GET",
                data:{
                  discussion_adminName:res_info.userInfo.nickName,
                  discussion_id:that.data.question_id,
                  info:that.data.comment_input,
                  type:"community_new_comment"
                }, 
                header: {
                  'Content-Type': 'application/json'
                },
                success: function(res) {
                  console.log("重新加载页面时返回的信息")
                  console.log("question_id"+that.data.question_id)
                  console.log(res.data)
                  wx.reLaunch({
                    url: '/pages/community-comment/community-comment?question_id='+that.data.question_id,
                  })
                }
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
  update_comment:function(event){
    var that = this;
    this.setData({
      comment_input:event.detail.value
    })
    content = event.detail.value
  },

  subscribe:function(event){
    wx.showToast({
      title: '关注成功',
    })
    var that = this;
    wx.getUserInfo({
      success: (res) => {
        wx.request({
          url: 'http://localhost:8888/web_war_exploded/account',
          method:"GET",
          data:{            
            click_user:res.userInfo.nickName,
            discussion_id:that.data.question_id,
            subscribe_user_name:event.currentTarget.dataset.text,
            type:"subscribe"
          }, 
          header: {
            'Content-Type': 'application/json'
          },
          success: function(res) {
            wx.reLaunch({
              url: '/pages/account/account',
            })
          }
        })
      },
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function (options) {


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

