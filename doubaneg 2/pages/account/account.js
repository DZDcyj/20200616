// pages/account/account.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    userinfo:{},
  },
  
  onShow(){
    const userinfo=wx.getStorageSync('userinfo');
    this.setData({userinfo})
  },
  //对于多朋的代码进行了一定的修改：刘子聿修改
  
})