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
    title: '返款计算方式',
    align:"center",
    dataIndex: 'refundCalWay_dictText'
   },
   {
    title: '默认成本',
    align:"center",
    dataIndex: 'discount'
   },
   {
    title: '税率',
    align:"center",
    dataIndex: 'taxRate'
   },
   {
    title: '报单上级',
    align:"center",
    dataIndex: 'upperConfigId_dictText'
   },
   {
    title: '上架状态',
    align:"center",
    dataIndex: 'shelf_dictText'
   },
   {
    title: '是否活动页显示',
    align:"center",
    dataIndex: 'showAct_dictText'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "项目",
      field: "projectId",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"uporder_project,project_name,id"
      },
      //colProps: {span: 6},
 	},
     {
      label: "产品名",
      field: "productName",
      component: 'Input', //TODO 范围查询
      //colProps: {span: 6},
	},
	{
      label: "返款计算方式",
      field: "refundCalWay",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"refund_cal_way"
      },
      //colProps: {span: 6},
 	},
	{
      label: "关闭自动推单",
      field: "closeAutoPush",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yn"
      },
      //colProps: {span: 6},
 	},
	{
      label: "关闭自动申请返款",
      field: "closeAutoRefund",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yn"
      },
      //colProps: {span: 6},
 	},
	{
      label: "上架状态",
      field: "shelf",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"shelf_status"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否活动页显示",
      field: "showAct",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yn"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否预售",
      field: "presale",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yn"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否刷货产品",
      field: "shuahuo",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yn"
      },
      //colProps: {span: 6},
 	},
	{
      label: "是否完结",
      field: "settlement",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"yn"
      },
      //colProps: {span: 6},
 	},
     {
      label: "开始报单时间",
      field: "starTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
     {
      label: "结束报单时间",
      field: "endTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
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
    field: 'refundCalWay',
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
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yn",
        type: "radio"
     },
  },
  {
    label: '关闭自动推单',
    field: 'closeAutoPush',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yn",
        type: "radio"
     },
  },
  {
    label: '关闭自动申请返款',
    field: 'closeAutoRefund',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yn",
        type: "radio"
     },
  },
  {
    label: '上架状态',
    field: 'shelf',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"shelf_status",
        type: "radio"
     },
  },
  {
    label: '是否显示配额',
    field: 'showQuota',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yn",
        type: "radio"
     },
  },
  {
    label: '是否活动页显示',
    field: 'showAct',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yn",
        type: "radio"
     },
  },
  {
    label: '是否预售',
    field: 'presale',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yn",
        type: "radio"
     },
  },
  {
    label: '是否收集评价图',
    field: 'collectEvaluateImg',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yn",
        type: "radio"
     },
  },
  {
    label: '是否收集物流单号',
    field: 'collectTrafficNo',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yn",
        type: "radio"
     },
  },
  {
    label: '是否刷货产品',
    field: 'shuahuo',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yn",
        type: "radio"
     },
  },
  {
    label: '是否完结',
    field: 'settlement',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"yn",
        type: "radio"
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
    component: 'Input',
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
//子表表格配置
export const uporderProductTypeRefundConfigColumns: JVxeColumn[] = [
    {
      title: '用户类型id',
      key: 'typeId',
      type: JVxeTypes.select,
      options:[],
      dictCode:"uporder_user_type,account_type,id",
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
export const uporderProductDefineFieldColumns: JVxeColumn[] = [
    {
      title: '字段名',
      key: 'fieldName',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '字段类型',
      key: 'fieldType',
      type: JVxeTypes.select,
      options:[],
      dictCode:"field_type",
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '字段标签',
      key: 'fieldLabel',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '是否必填',
      key: 'required',
      type: JVxeTypes.checkbox,
      customValue: [1,0],
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '可选值',
      key: 'optionValue',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
  ]
export const uporderProductUserLimitColumns: JVxeColumn[] = [
    {
      title: '用户id',
      key: 'userId',
      type: JVxeTypes.select,
      options:[],
      dictCode:"uporder_user,account,id",
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
        validateRules: [
          { required: true, message: '${title}不能为空' },
        ],
    },
    {
      title: '账号额度',
      key: 'limitAmount',
      type: JVxeTypes.inputNumber,
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
export const uporderProductBuyLinkColumns: JVxeColumn[] = [
    {
      title: '链接名',
      key: 'linkName',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '链接地址',
      key: 'linkUrl',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
  ]


// 高级查询数据
export const superQuerySchema = {
  projectId: {title: '项目',order: 0,view: 'list', type: 'string',dictTable: "uporder_project", dictCode: 'id', dictText: 'project_name',},
  productName: {title: '产品名',order: 1,view: 'text', type: 'string',},
  refundCalWay: {title: '返款计算方式',order: 7,view: 'number', type: 'number',dictCode: 'refund_cal_way',},
  discount: {title: '默认成本',order: 8,view: 'number', type: 'number',},
  taxRate: {title: '税率',order: 9,view: 'number', type: 'number',},
  upperConfigId: {title: '报单上级',order: 11,view: 'list', type: 'string',dictTable: "uporder_config", dictCode: 'id', dictText: 'upper_name',},
  shelf: {title: '上架状态',order: 16,view: 'number', type: 'number',dictCode: 'shelf_status',},
  showAct: {title: '是否活动页显示',order: 18,view: 'number', type: 'number',dictCode: 'yn',},
  //子表高级查询
  uporderProductMediumText: {
    title: '产品文本表',
    view: 'table',
    fields: {
    }
  },
  uporderProductTypeRefundConfig: {
    title: '产品用户类型折扣表',
    view: 'table',
    fields: {
        typeId: {title: '用户类型id',order: 0,view: 'list', type: 'string',dictTable: "uporder_user_type", dictCode: 'id', dictText: 'account_type',},
        discount: {title: '折扣',order: 1,view: 'number', type: 'number',},
    }
  },
  uporderProductDefineField: {
    title: '产品自定义字段表',
    view: 'table',
    fields: {
    }
  },
  uporderProductUserLimit: {
    title: '报单产品用户额度表',
    view: 'table',
    fields: {
    }
  },
  uporderProductBuyLink: {
    title: '报单产品购买链接',
    view: 'table',
    fields: {
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