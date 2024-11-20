import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import {JVxeTypes,JVxeColumn} from '/@/components/jeecg/JVxeTable/types'
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '项目',
    align:"center",
    dataIndex: 'projectId_dictText'
   },
   {
    title: '产品名',
    align:"center",
    dataIndex: 'productName'
   },
   {
    title: '总额度',
    align:"center",
    dataIndex: 'totalLimitMoney'
   },
   {
    title: '剩余额度',
    align:"center",
    dataIndex: 'leftLimitMoney'
   },
   {
    title: '返款计算方式',
    align:"center",
    dataIndex: 'inRefundCalWay_dictText'
   },
   {
    title: '税率',
    align:"center",
    dataIndex: 'taxRate'
   },
   {
    title: '进价成本',
    align:"center",
    dataIndex: 'inDiscount'
   },
   {
    title: '上架状态',
    align:"center",
    dataIndex: 'shelf',
    customRender:({text}) => {
       return  render.renderSwitch(text, [{text:'是',value:'Y'},{text:'否',value:'N'}])
     },
   },
   {
    title: '是否显示配额',
    align:"center",
    dataIndex: 'showQuota',
    customRender:({text}) => {
       return  render.renderSwitch(text, [{text:'是',value:'Y'},{text:'否',value:'N'}])
     },
   },
   {
    title: '是否活动页显示',
    align:"center",
    dataIndex: 'showAct',
    customRender:({text}) => {
       return  render.renderSwitch(text, [{text:'是',value:'Y'},{text:'否',value:'N'}])
     },
   },
   {
    title: '是否预售',
    align:"center",
    dataIndex: 'presale',
    customRender:({text}) => {
       return  render.renderSwitch(text, [{text:'是',value:'Y'},{text:'否',value:'N'}])
     },
   },
   {
    title: '是否收集评价图',
    align:"center",
    dataIndex: 'collectEvaluateImg',
    customRender:({text}) => {
       return  render.renderSwitch(text, [{text:'是',value:'Y'},{text:'否',value:'N'}])
     },
   },
   {
    title: '是否收集物流单号',
    align:"center",
    dataIndex: 'collectTrafficNo',
    customRender:({text}) => {
       return  render.renderSwitch(text, [{text:'是',value:'Y'},{text:'否',value:'N'}])
     },
   },
   {
    title: '是否刷货产品',
    align:"center",
    dataIndex: 'shuahuo',
    customRender:({text}) => {
       return  render.renderSwitch(text, [{text:'是',value:'Y'},{text:'否',value:'N'}])
     },
   },
   {
    title: '是否完结',
    align:"center",
    dataIndex: 'settlement',
    customRender:({text}) => {
       return  render.renderSwitch(text, [{text:'是',value:'Y'},{text:'否',value:'N'}])
     },
   },
   {
    title: '最大报单时间',
    align:"center",
    dataIndex: 'maxReportInterval'
   },
   {
    title: '开始报单时间',
    align:"center",
    dataIndex: 'starTime'
   },
   {
    title: '结束报单时间',
    align:"center",
    dataIndex: 'endTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "项目",
      field: 'projectId',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"uporder_project,project_name,id"
      },
      //colProps: {span: 6},
 	},
	{
      label: "产品名",
      field: 'productName',
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "报单上级",
      field: 'upperConfigId',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"uporder_config,upper_name,id"
      },
      //colProps: {span: 6},
 	},
	{
      label: "上架状态",
      field: 'shelf',
      component: 'JSwitch',
      componentProps:{
           query:true,
       },
      //colProps: {span: 6},
 	},
	{
      label: "是否显示配额",
      field: 'showQuota',
      component: 'JSwitch',
      componentProps:{
           query:true,
       },
      //colProps: {span: 6},
 	},
	{
      label: "是否活动页显示",
      field: 'showAct',
      component: 'JSwitch',
      componentProps:{
           query:true,
       },
      //colProps: {span: 6},
 	},
	{
      label: "是否收集评价图",
      field: 'collectEvaluateImg',
      component: 'JSwitch',
      componentProps:{
           query:true,
       },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '项目',
    field: 'projectId',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"uporder_project,project_name,id"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入项目!'},
          ];
     },
  },
  {
    label: '产品名',
    field: 'productName',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入产品名!'},
          ];
     },
  },
  {
    label: '总额度',
    field: 'totalLimitMoney',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入总额度!'},
          ];
     },
  },
  {
    label: '购买链接',
    field: 'buyUrl',
    component: 'Input',
  },
  {
    label: '描述',
    field: 'description',
    component: 'Input',
  },
  {
    label: '管理员备注',
    field: 'note',
    component: 'Input',
  },
  {
    label: '剩余额度',
    field: 'leftLimitMoney',
    component: 'InputNumber',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入剩余额度!'},
          ];
     },
  },
  {
    label: '返款计算方式',
    field: 'inRefundCalWay',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"refund_cal_way",
        type: "radio"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入返款计算方式!'},
          ];
     },
  },
  {
    label: '默认成本',
    field: 'discount',
    component: 'InputNumber',
  },
  {
    label: '税率',
    field: 'taxRate',
    component: 'InputNumber',
  },
  {
    label: '进价成本',
    field: 'inDiscount',
    component: 'InputNumber',
  },
  {
    label: '报单上级',
    field: 'upperConfigId',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"uporder_config,upper_name,id"
     },
  },
  {
    label: '上级报单链接',
    field: 'upperReportUrl',
    component: 'Input',
  },
  {
    label: '是否跟上级额度',
    field: 'validUpperLimit',
     component: 'JSwitch',
     componentProps:{
     },
  },
  {
    label: '关闭自动推单',
    field: 'closeAutoPush',
     component: 'JSwitch',
     componentProps:{
     },
  },
  {
    label: '关闭自动申请返款',
    field: 'closeAutoRefund',
     component: 'JSwitch',
     componentProps:{
     },
  },
  {
    label: '上架状态',
    field: 'shelf',
     component: 'JSwitch',
     componentProps:{
     },
  },
  {
    label: '是否显示配额',
    field: 'showQuota',
     component: 'JSwitch',
     componentProps:{
     },
  },
  {
    label: '是否活动页显示',
    field: 'showAct',
     component: 'JSwitch',
     componentProps:{
     },
  },
  {
    label: '是否预售',
    field: 'presale',
     component: 'JSwitch',
     componentProps:{
     },
  },
  {
    label: '是否收集评价图',
    field: 'collectEvaluateImg',
     component: 'JSwitch',
     componentProps:{
     },
  },
  {
    label: '是否收集物流单号',
    field: 'collectTrafficNo',
     component: 'JSwitch',
     componentProps:{
     },
  },
  {
    label: '是否刷货产品',
    field: 'shuahuo',
     component: 'JSwitch',
     componentProps:{
     },
  },
  {
    label: '是否完结',
    field: 'settlement',
     component: 'JSwitch',
     componentProps:{
     },
  },
  {
    label: '最大报单时间',
    field: 'maxReportInterval',
    component: 'InputNumber',
  },
  {
    label: '隐藏字段',
    field: 'reportHiddenFields',
    component: 'JCheckbox',
    componentProps:{
        dictCode:""
     },
  },
  {
    label: '开始报单时间',
    field: 'starTime',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '结束报单时间',
    field: 'endTime',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '返款规则',
    field: 'refundRule',
    component: 'InputTextArea',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];
//子表单数据
//子表列表数据
export const uporderProductMediumTextColumns: BasicColumn[] = [
   {
    title: '下单方案',
    align:"center",
    dataIndex: 'planHtml'
   },
   {
    title: '弹框提示',
    align:"center",
    dataIndex: 'reportPopupsTip'
   },
];
export const uporderProductMediumTextFormSchema: FormSchema[] = [
  {
    label: '下单方案',
    field: 'planHtml',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入下单方案!'},
          ];
     },
  },
  {
    label: '弹框提示',
    field: 'reportPopupsTip',
    component: 'InputTextArea',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入弹框提示!'},
          ];
     },
  },
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];
//子表列表数据
export const uporderProductTypeRefundConfigColumns: BasicColumn[] = [
   {
    title: '用户类型id',
    align:"center",
    dataIndex: 'typeId'
   },
   {
    title: '折扣',
    align:"center",
    dataIndex: 'discount'
   },
];
//子表表格配置
export const uporderProductTypeRefundConfigJVxeColumns: JVxeColumn[] = [
    {
      title: '用户类型id',
      key: 'typeId',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
        validateRules: [
          { required: true, message: '${title}不能为空' },
        ],
    },
    {
      title: '折扣',
      key: 'discount',
      type: JVxeTypes.inputNumber,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
  ]

// 高级查询数据
export const superQuerySchema = {
  projectId: {title: '项目',order: 0,view: 'list', type: 'string',dictTable: "uporder_project", dictCode: 'id', dictText: 'project_name',},
  productName: {title: '产品名',order: 1,view: 'text', type: 'string',},
  totalLimitMoney: {title: '总额度',order: 2,view: 'number', type: 'number',},
  leftLimitMoney: {title: '剩余额度',order: 6,view: 'number', type: 'number',},
  inRefundCalWay: {title: '返款计算方式',order: 7,view: 'number', type: 'number',dictCode: 'refund_cal_way',},
  taxRate: {title: '税率',order: 9,view: 'number', type: 'number',},
  inDiscount: {title: '进价成本',order: 10,view: 'number', type: 'number',},
  shelf: {title: '上架状态',order: 16,view: 'switch', type: 'string',},
  showQuota: {title: '是否显示配额',order: 17,view: 'switch', type: 'string',},
  showAct: {title: '是否活动页显示',order: 18,view: 'switch', type: 'string',},
  presale: {title: '是否预售',order: 19,view: 'switch', type: 'string',},
  collectEvaluateImg: {title: '是否收集评价图',order: 20,view: 'switch', type: 'string',},
  collectTrafficNo: {title: '是否收集物流单号',order: 21,view: 'switch', type: 'string',},
  shuahuo: {title: '是否刷货产品',order: 22,view: 'switch', type: 'string',},
  settlement: {title: '是否完结',order: 23,view: 'switch', type: 'string',},
  maxReportInterval: {title: '最大报单时间',order: 24,view: 'number', type: 'number',},
  starTime: {title: '开始报单时间',order: 26,view: 'datetime', type: 'string',},
  endTime: {title: '结束报单时间',order: 27,view: 'datetime', type: 'string',},
  //子表高级查询
  uporderProductMediumText: {
    title: '产品文本表',
    view: 'table',
    fields: {
        planHtml: {title: '下单方案',order: 0,view: 'textarea', type: 'string',},
        reportPopupsTip: {title: '弹框提示',order: 1,view: 'textarea', type: 'string',},
    }
  },
  uporderProductTypeRefundConfig: {
    title: '产品用户类型折扣表',
    view: 'table',
    fields: {
        typeId: {title: '用户类型id',order: 0,view: 'text', type: 'string',},
        discount: {title: '折扣',order: 1,view: 'number', type: 'number',},
    }
  },
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}