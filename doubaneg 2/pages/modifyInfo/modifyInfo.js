Page({
 
  /**
   * 页面的初始数据
   */
  data: {
    // onPullDownRefresh: function () {
    //   wx.stopPullDownRefresh()
    // },
    myinfo:null
  
  },
 
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var stu = wx.getStorageSync('student');
    this.setData({ myinfo: stu });
    // console.log(this.data.myinfo);
  },
})

