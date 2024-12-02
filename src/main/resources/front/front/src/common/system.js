export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除"],"menu":"工作人员","menuJump":"列表","tableName":"gongzuorenyuan"}],"menu":"工作人员管理"},{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["新增","查看","修改","删除","打印"],"menu":"献血人员","menuJump":"列表","tableName":"xianxuerenyuan"}],"menu":"献血人员管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","删除","打印","修改"],"menu":"采血登记","menuJump":"列表","tableName":"caixuedengji"}],"menu":"采血登记管理"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["查看","删除","打印","修改"],"menu":"血液检测","menuJump":"列表","tableName":"xueyejiance"}],"menu":"血液检测管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","删除","打印","修改"],"menu":"体检信息","menuJump":"列表","tableName":"tijianxinxi"}],"menu":"体检信息管理"},{"child":[{"appFrontIcon":"cuIcon-camera","buttons":["查看","删除","打印","修改","新增"],"menu":"血库信息","menuJump":"列表","tableName":"xuekuxinxi"}],"menu":"血库信息管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["查看","修改","删除","打印"],"menu":"血液入库","menuJump":"列表","tableName":"xueyeruku"}],"menu":"血液入库管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","修改","删除","打印"],"menu":"血液出库","menuJump":"列表","tableName":"xueyechuku"}],"menu":"血液出库管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["查看","修改","删除","打印"],"menu":"成分录入","menuJump":"列表","tableName":"chengfenluru"}],"menu":"成分录入管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","修改","删除","打印"],"menu":"营养补贴","menuJump":"列表","tableName":"yingyangbutie"}],"menu":"营养补贴管理"},{"child":[{"appFrontIcon":"cuIcon-send","buttons":["查看","修改","回复","删除"],"menu":"留言板管理","tableName":"messages"}],"menu":"留言板管理"},{"child":[{"appFrontIcon":"cuIcon-addressbook","buttons":["查看","修改","删除"],"menu":"轮播图管理","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","修改","删除"],"menu":"医疗资讯","tableName":"news"},{"appFrontIcon":"cuIcon-service","buttons":["新增","查看","修改","删除"],"menu":"医院客服","tableName":"chat"}],"menu":"系统管理"}],"frontMenu":[],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"管理员","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-cardboard","buttons":["查看","采血","体检","补贴","打印"],"menu":"献血人员","menuJump":"列表","tableName":"xianxuerenyuan"}],"menu":"献血人员管理"},{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看","打印","检测","删除"],"menu":"采血登记","menuJump":"列表","tableName":"caixuedengji"}],"menu":"采血登记管理"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["查看","打印","删除"],"menu":"血液检测","menuJump":"列表","tableName":"xueyejiance"}],"menu":"血液检测管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","打印","删除"],"menu":"体检信息","menuJump":"列表","tableName":"tijianxinxi"}],"menu":"体检信息管理"},{"child":[{"appFrontIcon":"cuIcon-camera","buttons":["查看","打印","入库","出库"],"menu":"血库信息","menuJump":"列表","tableName":"xuekuxinxi"}],"menu":"血库信息管理"},{"child":[{"appFrontIcon":"cuIcon-taxi","buttons":["查看","打印","删除"],"menu":"血液入库","menuJump":"列表","tableName":"xueyeruku"}],"menu":"血液入库管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","打印","删除"],"menu":"血液出库","menuJump":"列表","tableName":"xueyechuku"}],"menu":"血液出库管理"},{"child":[{"appFrontIcon":"cuIcon-keyboard","buttons":["新增","查看","修改","删除","打印"],"menu":"成分录入","menuJump":"列表","tableName":"chengfenluru"}],"menu":"成分录入管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","删除","打印"],"menu":"营养补贴","menuJump":"列表","tableName":"yingyangbutie"}],"menu":"营养补贴管理"}],"frontMenu":[],"hasBackLogin":"是","hasBackRegister":"是","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"工作人员","tableName":"gongzuorenyuan"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-phone","buttons":["查看"],"menu":"采血登记","menuJump":"列表","tableName":"caixuedengji"}],"menu":"采血登记管理"},{"child":[{"appFrontIcon":"cuIcon-wenzi","buttons":["查看"],"menu":"血液检测","menuJump":"列表","tableName":"xueyejiance"}],"menu":"血液检测管理"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看"],"menu":"体检信息","menuJump":"列表","tableName":"tijianxinxi"}],"menu":"体检信息管理"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看"],"menu":"营养补贴","menuJump":"列表","tableName":"yingyangbutie"}],"menu":"营养补贴管理"}],"frontMenu":[],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"献血人员","tableName":"xianxuerenyuan"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
