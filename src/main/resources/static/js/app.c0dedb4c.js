(function(e){function t(t){for(var r,o,u=t[0],c=t[1],i=t[2],l=0,d=[];l<u.length;l++)o=u[l],Object.prototype.hasOwnProperty.call(a,o)&&a[o]&&d.push(a[o][0]),a[o]=0;for(r in c)Object.prototype.hasOwnProperty.call(c,r)&&(e[r]=c[r]);f&&f(t);while(d.length)d.shift()();return s.push.apply(s,i||[]),n()}function n(){for(var e,t=0;t<s.length;t++){for(var n=s[t],r=!0,o=1;o<n.length;o++){var u=n[o];0!==a[u]&&(r=!1)}r&&(s.splice(t--,1),e=c(c.s=n[0]))}return e}var r={},o={app:0},a={app:0},s=[];function u(e){return c.p+"js/"+({}[e]||e)+"."+{"chunk-18458ebc":"db8d82c2","chunk-32db800e":"b401385f","chunk-2d237c54":"c18b0877","chunk-4e552d82":"d6c8c817","chunk-5f5e6eb3":"d488bba7","chunk-2d0d03c8":"adc0331f","chunk-33b8cd94":"4bdda80f","chunk-df7e035a":"091ba510"}[e]+".js"}function c(t){if(r[t])return r[t].exports;var n=r[t]={i:t,l:!1,exports:{}};return e[t].call(n.exports,n,n.exports,c),n.l=!0,n.exports}c.e=function(e){var t=[],n={"chunk-32db800e":1,"chunk-5f5e6eb3":1};o[e]?t.push(o[e]):0!==o[e]&&n[e]&&t.push(o[e]=new Promise((function(t,n){for(var r="css/"+({}[e]||e)+"."+{"chunk-18458ebc":"31d6cfe0","chunk-32db800e":"d56b9f77","chunk-2d237c54":"31d6cfe0","chunk-4e552d82":"31d6cfe0","chunk-5f5e6eb3":"ce74e4ee","chunk-2d0d03c8":"31d6cfe0","chunk-33b8cd94":"31d6cfe0","chunk-df7e035a":"31d6cfe0"}[e]+".css",a=c.p+r,s=document.getElementsByTagName("link"),u=0;u<s.length;u++){var i=s[u],l=i.getAttribute("data-href")||i.getAttribute("href");if("stylesheet"===i.rel&&(l===r||l===a))return t()}var d=document.getElementsByTagName("style");for(u=0;u<d.length;u++){i=d[u],l=i.getAttribute("data-href");if(l===r||l===a)return t()}var f=document.createElement("link");f.rel="stylesheet",f.type="text/css",f.onload=t,f.onerror=function(t){var r=t&&t.target&&t.target.src||a,s=new Error("Loading CSS chunk "+e+" failed.\n("+r+")");s.code="CSS_CHUNK_LOAD_FAILED",s.request=r,delete o[e],f.parentNode.removeChild(f),n(s)},f.href=a;var m=document.getElementsByTagName("head")[0];m.appendChild(f)})).then((function(){o[e]=0})));var r=a[e];if(0!==r)if(r)t.push(r[2]);else{var s=new Promise((function(t,n){r=a[e]=[t,n]}));t.push(r[2]=s);var i,l=document.createElement("script");l.charset="utf-8",l.timeout=120,c.nc&&l.setAttribute("nonce",c.nc),l.src=u(e);var d=new Error;i=function(t){l.onerror=l.onload=null,clearTimeout(f);var n=a[e];if(0!==n){if(n){var r=t&&("load"===t.type?"missing":t.type),o=t&&t.target&&t.target.src;d.message="Loading chunk "+e+" failed.\n("+r+": "+o+")",d.name="ChunkLoadError",d.type=r,d.request=o,n[1](d)}a[e]=void 0}};var f=setTimeout((function(){i({type:"timeout",target:l})}),12e4);l.onerror=l.onload=i,document.head.appendChild(l)}return Promise.all(t)},c.m=e,c.c=r,c.d=function(e,t,n){c.o(e,t)||Object.defineProperty(e,t,{enumerable:!0,get:n})},c.r=function(e){"undefined"!==typeof Symbol&&Symbol.toStringTag&&Object.defineProperty(e,Symbol.toStringTag,{value:"Module"}),Object.defineProperty(e,"__esModule",{value:!0})},c.t=function(e,t){if(1&t&&(e=c(e)),8&t)return e;if(4&t&&"object"===typeof e&&e&&e.__esModule)return e;var n=Object.create(null);if(c.r(n),Object.defineProperty(n,"default",{enumerable:!0,value:e}),2&t&&"string"!=typeof e)for(var r in e)c.d(n,r,function(t){return e[t]}.bind(null,r));return n},c.n=function(e){var t=e&&e.__esModule?function(){return e["default"]}:function(){return e};return c.d(t,"a",t),t},c.o=function(e,t){return Object.prototype.hasOwnProperty.call(e,t)},c.p="/",c.oe=function(e){throw console.error(e),e};var i=window["webpackJsonp"]=window["webpackJsonp"]||[],l=i.push.bind(i);i.push=t,i=i.slice();for(var d=0;d<i.length;d++)t(i[d]);var f=l;s.push([0,"chunk-vendors"]),n()})({0:function(e,t,n){e.exports=n("56d7")},"56d7":function(e,t,n){"use strict";n.r(t);n("e260"),n("e6cf"),n("cca6"),n("a79d");var r=n("2b0e"),o=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",{attrs:{id:"app"}},[n("router-view")],1)},a=[],s=n("2877"),u={},c=Object(s["a"])(u,o,a,!1,null,null,null),i=c.exports,l=n("a18c"),d=n("2f62");r["default"].use(d["a"]);var f=new d["a"].Store({state:{routes:[]},mutations:{initRoutes:function(e,t){e.routes=t}},actions:{}}),m=n("5c96"),p=n.n(m),h=(n("0fae"),n("1f54"),n("7c15")),g=(n("159b"),n("b0c0"),n("2ca0"),function(e,t){t.state.routes.length>0||Object(h["b"])("/system/config/menu").then((function(n){if(n){var r=b(n);e.addRoutes(r),t.commit("initRoutes",r)}}))}),b=function e(t){var r=[];return t.forEach((function(t){var o=t.path,a=t.component,s=t.name,u=t.meta,c=t.iconCls,i=t.children;i&&i instanceof Array&&(i=e(i));var l={path:o,name:s,iconCls:c,meta:u,children:i,component:function(e){a.startsWith("Home")?Promise.all([n.e("chunk-5f5e6eb3"),n.e("chunk-32db800e"),n.e("chunk-33b8cd94")]).then(function(){var t=[n("feca")("./"+a+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe):a.startsWith("Emp")?Promise.all([n.e("chunk-32db800e"),n.e("chunk-2d237c54")]).then(function(){var t=[n("fd11")("./"+a+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe):a.startsWith("Per")?n.e("chunk-4e552d82").then(function(){var t=[n("ee1c")("./"+a+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe):a.startsWith("Sal")?n.e("chunk-df7e035a").then(function(){var t=[n("d7e6")("./"+a+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe):a.startsWith("Sta")?n.e("chunk-18458ebc").then(function(){var t=[n("0b22")("./"+a+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe):a.startsWith("Sys")&&Promise.all([n.e("chunk-5f5e6eb3"),n.e("chunk-2d0d03c8")]).then(function(){var t=[n("66b4")("./"+a+".vue")];e.apply(null,t)}.bind(this)).catch(n.oe)}};r.push(l)})),r};r["default"].prototype.postKeyValueRequest=h["c"],r["default"].prototype.postRequest=h["d"],r["default"].prototype.putRequest=h["e"],r["default"].prototype.getRequest=h["b"],r["default"].prototype.deleteRequest=h["a"],r["default"].config.productionTip=!1,r["default"].use(p.a),l["a"].beforeEach((function(e,t,n){"/"==e.path?n():window.sessionStorage.getItem("user")?(g(l["a"],f),n()):n("/?redirect="+e.path)})),new r["default"]({router:l["a"],store:f,render:function(e){return e(i)}}).$mount("#app")},"5ced":function(e,t,n){},"7c15":function(e,t,n){"use strict";n.d(t,"c",(function(){return c})),n.d(t,"d",(function(){return i})),n.d(t,"e",(function(){return l})),n.d(t,"b",(function(){return d})),n.d(t,"a",(function(){return f}));n("ac1f"),n("5319");var r=n("bc3a"),o=n.n(r),a=n("5c96"),s=(n("ebda"),n("a18c"));o.a.interceptors.response.use((function(e){return e.status&&200==e.status&&500==e.data.status?(a["Message"].error({message:e.data.msg}),void console.log(e.data.msg)):(e.data.msg&&a["Message"].success({message:e.data.msg}),e.data)}),(function(e){504==e.response.status||404==e.response.status?a["Message"].error({message:"服务器被吃了( ╯□╰ )"}):403==e.response.status?a["Message"].error({message:"权限不足，请联系管理员"}):401==e.response.status?(a["Message"].error({message:"尚未登录，请登录"}),s["a"].replace("/")):e.response.data.msg?a["Message"].error({message:e.response.data.msg}):a["Message"].error({message:"未知错误"})}));var u="",c=function(e,t){return o()({method:"post",url:"".concat(u).concat(e),data:t,transformRequest:[function(e){var t="";for(var n in e)t+=encodeURIComponent(n)+"="+encodeURIComponent(e[n])+"&";return t}],headers:{"Content-Type":"application/x-www-form-urlencoded"}})},i=function(e,t){return o()({method:"post",url:"".concat(u).concat(e),data:t})},l=function(e,t){return o()({method:"put",url:"".concat(u).concat(e),data:t})},d=function(e,t){return o()({method:"get",url:"".concat(u).concat(e),data:t})},f=function(e,t){return o()({method:"delete",url:"".concat(u).concat(e),data:t})}},a18c:function(e,t,n){"use strict";var r=n("2b0e"),o=n("8c4f"),a=n("a55b"),s=n("bb51");r["default"].use(o["a"]);var u=[{path:"/",name:"Login",component:a["default"],hidden:!0},{path:"/home",name:"Home",component:s["default"],hidden:!0}],c=new o["a"]({routes:u});t["a"]=c},a55b:function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("el-form",{directives:[{name:"loading",rawName:"v-loading",value:e.loading,expression:"loading"}],ref:"ruleForm",staticClass:"loginContainer",attrs:{rules:e.rules,model:e.loginForm,"element-loading-text":"正在登录","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)"}},[n("h3",{staticClass:"loginTitle"},[e._v("系统登录")]),n("el-form-item",{attrs:{prop:"username"}},[n("el-input",{attrs:{type:"text","auto-complete":"off",placeholder:"请输入用户名"},model:{value:e.loginForm.username,callback:function(t){e.$set(e.loginForm,"username",t)},expression:"loginForm.username"}})],1),n("el-form-item",{attrs:{prop:"password"}},[n("el-input",{attrs:{type:"password","auto-complete":"off",placeholder:"请输入密码"},model:{value:e.loginForm.password,callback:function(t){e.$set(e.loginForm,"password",t)},expression:"loginForm.password"}})],1),n("el-checkbox",{staticClass:"loginRememberme",model:{value:e.checked,callback:function(t){e.checked=t},expression:"checked"}},[e._v("记住我")]),n("el-button",{staticStyle:{width:"100%"},attrs:{type:"primary"},on:{click:function(t){return e.submitLogin("ruleForm")}},nativeOn:{keydown:function(t){return!t.type.indexOf("key")&&e._k(t.keyCode,"enter",13,t.key,"Enter")?null:e.submitLogin.apply(null,arguments)}}},[e._v("登录")])],1)],1)},o=[],a=(n("ac1f"),n("5319"),{name:"Login",data:function(){return{loading:!1,loginForm:{username:"admin",password:"123"},checked:!0,rules:{username:[{required:!0,message:"请输入用户名",trigger:"blur"}],password:[{required:!0,message:"请输入密码",trigger:"blur"}]}}},methods:{submitLogin:function(e){var t=this;this.$refs[e].validate((function(e){if(!e)return t.$message.error("请输入用户名或密码"),!1;t.loading=!0,t.postKeyValueRequest("/doLogin",t.loginForm).then((function(e){if(t.loading=!1,e){window.sessionStorage.setItem("user",JSON.stringify(e.object));var n=t.$route.query.redirect;t.$router.replace("/"==n||void 0==n?"/home":n)}}))}))}}}),s=a,u=(n("d6db"),n("2877")),c=Object(u["a"])(s,r,o,!1,null,null,null);t["default"]=c.exports},bb51:function(e,t,n){"use strict";n.r(t);var r=function(){var e=this,t=e.$createElement,n=e._self._c||t;return n("div",[n("el-container",[n("el-header",{staticClass:"homeHeader"},[n("div",{staticClass:"title"},[e._v("微人事")]),n("el-dropdown",{staticClass:"userInfo",on:{command:e.commandHandler}},[n("span",{staticClass:"el-dropdown-link"},[e._v(" "+e._s(e.user.name)),n("i",[n("img",{attrs:{src:e.user.userface,alt:""}})])]),n("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[n("el-dropdown-item",{attrs:{command:"userinfo"}},[e._v("个人中心")]),n("el-dropdown-item",{attrs:{command:"setting"}},[e._v("设置")]),n("el-dropdown-item",{attrs:{divided:"",command:"logout"}},[e._v("注销登录")])],1)],1)],1),n("el-container",[n("el-aside",{attrs:{width:"200px"}},[n("el-menu",{attrs:{router:""}},e._l(e.routes,(function(t,r){return t.hidden?e._e():n("el-submenu",{key:r,attrs:{index:r+""}},[n("template",{slot:"title"},[n("i",{class:t.iconCls,staticStyle:{"margin-right":"5px",color:"#409eff"}}),n("span",[e._v(e._s(t.name))])]),e._l(t.children,(function(t,r){return n("el-menu-item",{key:r,attrs:{index:t.path}},[e._v(e._s(t.name))])}))],2)})),1)],1),n("el-main",["/home"!=this.$router.currentRoute.path?n("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[n("el-breadcrumb-item",{attrs:{to:{path:"/home"}}},[e._v("首页")]),n("el-breadcrumb-item",[e._v(e._s(this.$router.currentRoute.name))])],1):e._e(),"/home"==this.$router.currentRoute.path?n("div",{staticClass:"homeWelcome"},[e._v(" 欢迎来到微人事! ")]):e._e(),n("router-view",{staticClass:"homeRouterView"})],1)],1)],1)],1)},o=[],a=(n("ac1f"),n("5319"),n("7c15"),{name:"Home",data:function(){return{user:JSON.parse(window.sessionStorage.getItem("user"))}},computed:{routes:function(){return this.$store.state.routes}},methods:{commandHandler:function(e){var t=this;"logout"==e&&this.$confirm("此操作将注销登录，是否继续?","提升",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){t.getRequest("/logout"),window.sessionStorage.removeItem("user"),t.$store.commit("initRoutes",[]),t.$router.replace("/")})).catch((function(){t.$message({type:"info",message:"已取消注销登录"})}))}}}),s=a,u=(n("cccb"),n("2877")),c=Object(u["a"])(s,r,o,!1,null,null,null);t["default"]=c.exports},cccb:function(e,t,n){"use strict";n("5ced")},d6db:function(e,t,n){"use strict";n("e67a")},e67a:function(e,t,n){}});
//# sourceMappingURL=app.c0dedb4c.js.map