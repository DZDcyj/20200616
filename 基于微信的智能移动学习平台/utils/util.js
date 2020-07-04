const formatTime = date => {
  const year = date.getFullYear()
  const month = date.getMonth() + 1
  const day = date.getDate()
  const hour = date.getHours()
  const minute = date.getMinutes()
  const second = date.getSeconds()

  return [year, month, day].map(formatNumber).join('/') + ' ' + [hour, minute, second].map(formatNumber).join(':')
}

const formatNumber = n => {
  n = n.toString()
  return n[1] ? n : '0' + n
}

module.exports = {
  formatTime: formatTime
}

var index =  require("../data/data_index.js");
var comment   = require("../data/data_comment.js");


function getData(url) {
  return new Promise (function(resolve,reject){
      wx.request({
        url: url,
        data:{},
        header:{},
        success:function(res){ 
          console.log('success'),
          resolve(res);
        },
        fail:function(res){
          console.log('fail'),
          reject(res);
        }
      })
  })
}

function getData2(){
  return index.index
}


function getData3(){
  return comment.comment
}

module.exports.getData = getData;
module.exports.getData2 = getData2;
module.exports.getData3 = getData3;
