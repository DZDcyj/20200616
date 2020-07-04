// pages/account/account.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userinfo:{},
  },
  onLoad:function(options){
    var that = this;
    //获取用户信息
    wx.getUserInfo({
        success: function (res) {
          wx.request({
            url: 'http://localhost:8888/web_war_exploded/account',
            method:'GET',
            data : {
              name: res.userInfo.nickName,
              type:"account"
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

  onShow(){
    const userinfo=wx.getStorageSync('userinfo');
    this.setData({userinfo})
    console.log(userinfo)
  },
  //对于多朋的代码进行了一定的修改：刘子聿修改
  
})