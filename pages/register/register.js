//register.js

Page({
  onLoad: function() {},
  formSubmit: function(e) {
    if (e.detail.value.password != e.detail.value.passwordCheck) {
      wx.showToast({
        title: '密码不一致',
        duration: 2000
      })
      return
    }
    wx.request({
      url: 'http://192.168.20.120:8080/user/register',
      data: {
        username: e.detail.value.username,
        password: e.detail.value.password,
        telephone: e.detail.value.telephone,
        passwordCheck: e.detail.value.passwordCheck,
      },
      header: {
        'content-type': 'application/json'
      },
      success(res) {
        console.log(res.data)
      }
    })
  },
  formReset: function(e) {

  }
})