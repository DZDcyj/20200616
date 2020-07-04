Page({
 
  /**
   * 页面的初始数据
   */
  data: {
    userId:1,
    userName:"",
    userAge:"",
    userSex:"",
    userAddress:"",
    recomment:""
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
            url: 'http://localhost:8888/web_war_exploded/modify',
            method:'GET',
            data : {
              name: res.userInfo.nickName,
              type:"modify"
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
  getName:function(event){
    this.setData({
      userName:event.detail.value
    })
  },
  getAge:function(event){
    this.setData({
      userAge:event.detail.value
    })
  },
  getSex:function(event){
    this.setData({
      userSex:event.detail.value
    })
  },
  getAddress:function(event){
    this.setData({
      userAddress:event.detail.value
    })
  },
  getRecommend:function(event){
    this.setData({
      recomment:event.detail.value
    })
  },

  saveInfo:function(event){
    var that = this;
    //获取用户信息
    wx.getUserInfo({
        success: function (res) {
          wx.request({
            url: 'http://localhost:8888/web_war_exploded/modify',
            method:'GET',
            data : {
              id:2,
              name:that.data.userName,
              age:that.data.userAge,
              sex:that.data.userSex,
              addr:that.data.userAddress,
              type:"modfiysubmit"
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

