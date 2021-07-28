(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-df7e035a"],{1937:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("工资表查询")])},n=[],i={name:"SalSearch"},r=i,s=a("2877"),o=Object(s["a"])(r,l,n,!1,null,"70c7af6a",null);e["default"]=o.exports},"21c7":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("工资表管理")])},n=[],i={name:"SalTable"},r=i,s=a("2877"),o=Object(s["a"])(r,l,n,!1,null,"9f4c58da",null);e["default"]=o.exports},"2bc5":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",{staticStyle:{display:"flex","justify-content":"space-between"}},[a("el-button",{attrs:{icon:"el-icon-plus",type:"primary",size:"small"},on:{click:t.showAddSalarView}},[t._v("添加工资套餐")]),a("el-button",{attrs:{icon:"el-icon-refresh",size:"small",type:"success"}})],1),a("div",{staticStyle:{"margin-top":"10px"}},[a("el-table",{attrs:{data:t.salaryies,border:"",stripe:"",size:"small"}},[a("el-table-column",{attrs:{type:"selection",width:"50"}}),a("el-table-column",{attrs:{width:"120",prop:"name",label:"账套名称"}}),a("el-table-column",{attrs:{width:"70",prop:"basicSalary",label:"基本工资"}}),a("el-table-column",{attrs:{width:"70",prop:"trafficSalary",label:"交通补助"}}),a("el-table-column",{attrs:{width:"70",prop:"lunchSalary",label:"午餐补助"}}),a("el-table-column",{attrs:{width:"70",prop:"bonus",label:"奖金"}}),a("el-table-column",{attrs:{width:"100",prop:"createDate",label:"启用时间"}}),a("el-table-column",{attrs:{label:"养老金",align:"center"}},[a("el-table-column",{attrs:{width:"70",prop:"pensionPer",label:"比率"}}),a("el-table-column",{attrs:{width:"70",prop:"pensionBase",label:"基数"}})],1),a("el-table-column",{attrs:{label:"医疗保险",align:"center"}},[a("el-table-column",{attrs:{width:"70",prop:"medicalPer",label:"比率"}}),a("el-table-column",{attrs:{width:"70",prop:"medicalBase",label:"基数"}})],1),a("el-table-column",{attrs:{label:"公积金",align:"center"}},[a("el-table-column",{attrs:{width:"70",prop:"accumulationFundPer",label:"比率"}}),a("el-table-column",{attrs:{width:"70",prop:"accumulationFundBase",label:"基数"}})],1),a("el-table-column",{attrs:{label:"操作"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"small"},on:{click:function(a){return t.showEditSalaryView(e.row)}}},[t._v("编辑")]),a("el-button",{attrs:{size:"small",type:"danger"},on:{click:function(a){return t.deleteSalary(e.row)}}},[t._v("删除")])]}}])})],1)],1),a("el-dialog",{attrs:{title:t.salaryTitle,visible:t.dialogVisible,width:"50%"},on:{"update:visible":function(e){t.dialogVisible=e}}},[a("div",{staticStyle:{display:"flex","justify-content":"space-around","align-items":"center"}},[a("el-steps",{attrs:{direction:"vertical",active:t.activeItemIndex}},t._l(t.salaryItemName,(function(t,e){return a("el-step",{key:e,attrs:{title:t}})})),1),t._l(t.salary,(function(e,l,n){return a("el-input",{directives:[{name:"show",rawName:"v-show",value:t.activeItemIndex==n,expression:"activeItemIndex == index"}],key:n,staticStyle:{width:"200px"},attrs:{placeholder:"请输入"+t.salaryItemName[n]+"..."},model:{value:t.salary[l],callback:function(e){t.$set(t.salary,l,e)},expression:"salary[title]"}})}))],2),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{on:{click:t.preStep}},[t._v(t._s(10==t.activeItemIndex?"取消":"上一步"))]),a("el-button",{attrs:{type:"primary"},on:{click:t.nextStep}},[t._v(t._s(10==t.activeItemIndex?"确定":"下一步"))])],1)])],1)},n=[],i=(a("b0c0"),{name:"SalSob",data:function(){return{salaryies:[],dialogVisible:!1,activeItemIndex:0,salaryTitle:"添加工资账套",salaryItemName:["账套名称","基本工资","交通补助","午餐补助","奖金","养老金比率","养老金基数","医疗保险比率","医疗保险基数","公积金比率","公积金基数"],salary:{name:"",basicSalary:0,trafficSalary:0,lunchSalary:0,bonus:0,pensionPer:0,pensionBase:0,medicalPer:0,medicalBase:0,accumulationFundPer:0,accumulationFundBase:0}}},mounted:function(){this.initSalaries()},methods:{initSalaries:function(){var t=this;this.getRequest("/salary/sob/").then((function(e){e&&(t.salaryies=e)}))},showAddSalarView:function(){this.salary={name:"",basicSalary:0,trafficSalary:0,lunchSalary:0,bonus:0,pensionPer:0,pensionBase:0,medicalPer:0,medicalBase:0,accumulationFundPer:0,accumulationFundBase:0},this.salaryTitle="添加工资账套",this.activeItemIndex=0,this.dialogVisible=!0},showEditSalaryView:function(t){this.salaryTitle="修改工资账套",this.salary.name=t.name,this.salary.basicSalary=t.basicSalary,this.salary.trafficSalary=t.trafficSalary,this.salary.lunchSalary=t.lunchSalary,this.salary.bonus=t.bonus,this.salary.pensionPer=t.pensionPer,this.salary.pensionBase=t.pensionBase,this.salary.medicalPer=t.medicalPer,this.salary.medicalBase=t.medicalBase,this.salary.accumulationFundPer=t.accumulationFundPer,this.salary.accumulationFundBase=t.accumulationFundBase,this.salary.id=t.id,this.activeItemIndex=0,this.dialogVisible=!0},nextStep:function(){var t=this;10==this.activeItemIndex?this.salary.id?this.putRequest("/salary/sob/",this.salary).then((function(e){e&&(t.initSalaries(),t.dialogVisible=!1)})):this.postRequest("/salary/sob/",this.salary).then((function(e){e&&(t.initSalaries(),t.dialogVisible=!1)})):this.activeItemIndex++},preStep:function(){0!=this.activeItemIndex&&(10!=this.activeItemIndex?this.activeItemIndex--:this.dialogVisible=!1)},deleteSalary:function(t){var e=this;this.$confirm("此操作将永久删除【"+t.name+"】该工资账套, 是否继续?","提示",{confirmButtonText:"确定",cancelButtonText:"取消",type:"warning"}).then((function(){e.deleteRequest("/salary/sob/"+t.id).then((function(t){t&&e.initSalaries()}))})).catch((function(){e.$message({type:"info",message:"已取消删除"})}))}}}),r=i,s=a("2877"),o=Object(s["a"])(r,l,n,!1,null,"4967355b",null);e["default"]=o.exports},"6ac98":function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[a("div",[a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:t.loading,expression:"loading"}],attrs:{"element-loading-text":"数据加载中","element-loading-spinner":"el-icon-loading","element-loading-background":"rgba(0, 0, 0, 0.8)",data:t.emps,border:"",stripe:"",size:"mini"}},[a("el-table-column",{attrs:{type:"selection",width:"50",align:"left"}}),a("el-table-column",{attrs:{prop:"name",width:"120",label:"姓名",fixed:"",align:"left"}}),a("el-table-column",{attrs:{prop:"workID",width:"120",label:"工号",align:"left"}}),a("el-table-column",{attrs:{prop:"email",width:"200",label:"电子邮件",align:"left"}}),a("el-table-column",{attrs:{prop:"phone",width:"130",label:"电话号码",align:"left"}}),a("el-table-column",{attrs:{prop:"department.name",width:"130",label:"所属部门",align:"left"}}),a("el-table-column",{attrs:{label:"工资账套",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[e.row.salary?a("el-tooltip",{attrs:{placement:"right"}},[a("div",{attrs:{slot:"content"},slot:"content"},[a("table",[a("tr",[a("td",[t._v("基本工资")]),a("td",[t._v(t._s(e.row.salary.basicSalary))])]),a("tr",[a("td",[t._v("交通补助")]),a("td",[t._v(t._s(e.row.salary.trafficSalary))])]),a("tr",[a("td",[t._v("午餐补助")]),a("td",[t._v(t._s(e.row.salary.lunchSalary))])]),a("tr",[a("td",[t._v("奖金")]),a("td",[t._v(t._s(e.row.salary.bonus))])]),a("tr",[a("td",[t._v("启用时间")]),a("td",[t._v(t._s(e.row.salary.createDate))])]),a("tr",[a("td",[t._v("养老金比率")]),a("td",[t._v(t._s(e.row.salary.pensionPer))])]),a("tr",[a("td",[t._v("养老金基数")]),a("td",[t._v(t._s(e.row.salary.pensionBase))])]),a("tr",[a("td",[t._v("医疗保险比率")]),a("td",[t._v(t._s(e.row.salary.medicalPer))])]),a("tr",[a("td",[t._v("医疗保险基数")]),a("td",[t._v(t._s(e.row.salary.medicalBase))])]),a("tr",[a("td",[t._v("公积金比率")]),a("td",[t._v(t._s(e.row.salary.accumulationFundPer))])]),a("tr",[a("td",[t._v("公积金比率基数")]),a("td",[t._v(t._s(e.row.salary.accumulationFundBase))])])])]),a("el-tag",[t._v(t._s(e.row.salary.name))])],1):a("el-tag",[t._v("暂未设置")])]}}])}),a("el-table-column",{attrs:{label:"操作",align:"center"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-popover",{attrs:{placement:"left",title:"修改工资账套",width:"200",trigger:"click"},on:{show:function(a){return t.showPop(e.row.salary)},hide:function(a){return t.hidePop(e.row)}}},[a("el-select",{attrs:{placeholder:"请选择",size:"mini"},model:{value:t.currentSalary,callback:function(e){t.currentSalary=e},expression:"currentSalary"}},t._l(t.salaryies,(function(t){return a("el-option",{key:t.id,attrs:{label:t.name,value:t.id}})})),1),a("el-button",{attrs:{slot:"reference",type:"danger",size:"mini"},slot:"reference"},[t._v("修改工资账套")])],1)]}}])})],1),a("div",{staticStyle:{"margin-top":"10px",display:"flex","justify-content":"flex-end"}},[a("el-pagination",{attrs:{background:"",layout:"sizes, prev, pager, next, jumper, ->, total, slot",total:t.total},on:{"current-change":t.currentChange,"size-change":t.sizeChange}})],1)],1)])},n=[],i={name:"SalSobCfg",data:function(){return{emps:[],salaryies:[],currentSalary:null,total:0,currentPage:1,currentSize:10,loading:!1}},mounted:function(){this.initEmps(),this.initSalaryies()},methods:{sizeChange:function(t){this.currentSize=t,this.initEmps()},currentChange:function(t){this.currentPage=t,this.initEmps()},hidePop:function(t){var e=this;null!=this.currentSalary&&this.putRequest("/salary/sobcfg/?eid="+t.id+"&sid="+this.currentSalary).then((function(t){t&&e.initEmps()}))},showPop:function(t){this.currentSalary=t?t.id:null},initSalaryies:function(){var t=this;this.getRequest("/salary/sobcfg/salary").then((function(e){e&&(t.salaryies=e)}))},initEmps:function(){var t=this;this.loading=!0,this.getRequest("/salary/sobcfg/?page="+this.currentPage+"&size="+this.currentSize).then((function(e){e&&(t.loading=!1,t.emps=e.data,t.total=e.total)}))}}},r=i,s=a("2877"),o=Object(s["a"])(r,l,n,!1,null,"a7b63c70",null);e["default"]=o.exports},d7e6:function(t,e,a){var l={"./SalMonth.vue":"fbac","./SalSearch.vue":"1937","./SalSob.vue":"2bc5","./SalSobCfg.vue":"6ac98","./SalTable.vue":"21c7"};function n(t){var e=i(t);return a(e)}function i(t){if(!a.o(l,t)){var e=new Error("Cannot find module '"+t+"'");throw e.code="MODULE_NOT_FOUND",e}return l[t]}n.keys=function(){return Object.keys(l)},n.resolve=i,t.exports=n,n.id="d7e6"},fbac:function(t,e,a){"use strict";a.r(e);var l=function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",[t._v("月末处理")])},n=[],i={name:"SalMonth"},r=i,s=a("2877"),o=Object(s["a"])(r,l,n,!1,null,"883ff71c",null);e["default"]=o.exports}}]);
//# sourceMappingURL=chunk-df7e035a.091ba510.js.map