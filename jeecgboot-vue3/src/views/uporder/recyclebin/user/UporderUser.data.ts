import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '账号',
    align:"center",
    dataIndex: 'account'
   },
   {
    title: '账号类型',
    align:"center",
    dataIndex: 'accountType_dictText'
   },
   {
    title: '支付宝账号',
    align:"center",
    dataIndex: 'alipayAccount'
   },
   {
    title: '支付宝姓名',
    align:"center",
    dataIndex: 'alipayName'
   },
   {
    title: '微信账号',
    align:"center",
    dataIndex: 'wechatAccount'
   },
   {
    title: '微信昵称',
    align:"center",
    dataIndex: 'wechatName'
   },
   {
    title: '最后报单时间',
    align:"center",
    dataIndex: 'lastOrderTime'
   },
   {
    title: '状态',
    align:"center",
    dataIndex: 'status_dictText'
   },
   {
    title: '头像',
    align:"center",
    dataIndex: 'headImage',
    customRender:render.renderImage,
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
     {
      label: "账号",
      field: "account",
      component: 'Input', //TODO 范围查询
      //colProps: {span: 6},
	},
	{
      label: "账号类型",
      field: 'accountType',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"uporder_user_type,account_type,id"
      },
      //colProps: {span: 6},
 	},
     {
      label: "支付宝账号",
      field: "alipayAccount",
      component: 'Input', //TODO 范围查询
      //colProps: {span: 6},
	},
     {
      label: "支付宝姓名",
      field: "alipayName",
      component: 'Input', //TODO 范围查询
      //colProps: {span: 6},
	},
     {
      label: "微信账号",
      field: "wechatAccount",
      component: 'Input', //TODO 范围查询
      //colProps: {span: 6},
	},
     {
      label: "微信昵称",
      field: "wechatName",
      component: 'Input', //TODO 范围查询
      //colProps: {span: 6},
	},
     {
      label: "最后报单时间",
      field: "lastOrderTime",
      component: 'RangePicker',
      componentProps: {
          valueType: 'Date',
          showTime:true
      },
      //colProps: {span: 6},
	},
	{
      label: "状态",
      field: 'status',
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"upoder_user_status"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '账号',
    field: 'account',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入账号!'},
          ];
     },
  },
  {
    label: '密码',
    field: 'password',
    defaultValue: "123456",
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入密码!'},
                 { pattern: /^.{6,16}$/, message: '请输入6到16位任意字符!'},
          ];
     },
  },
  {
    label: '账号类型',
    field: 'accountType',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"uporder_user_type,account_type,id"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入账号类型!'},
          ];
     },
  },
  {
    label: '支付宝账号',
    field: 'alipayAccount',
    component: 'Input',
  },
  {
    label: '支付宝姓名',
    field: 'alipayName',
    component: 'Input',
  },
  {
    label: '微信账号',
    field: 'wechatAccount',
    component: 'Input',
  },
  {
    label: '微信昵称',
    field: 'wechatName',
    component: 'Input',
  },
  {
    label: '状态',
    field: 'status',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"upoder_user_status"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入状态!'},
          ];
     },
  },
  {
    label: '头像',
    field: 'headImage',
     component: 'JImageUpload',
     componentProps:{
        fileMax: 0
      },
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];

// 高级查询数据
export const superQuerySchema = {
  account: {title: '账号',order: 0,view: 'text', type: 'string',},
  accountType: {title: '账号类型',order: 2,view: 'list', type: 'string',dictTable: "uporder_user_type", dictCode: 'id', dictText: 'account_type',},
  alipayAccount: {title: '支付宝账号',order: 3,view: 'text', type: 'string',},
  alipayName: {title: '支付宝姓名',order: 4,view: 'text', type: 'string',},
  wechatAccount: {title: '微信账号',order: 5,view: 'text', type: 'string',},
  wechatName: {title: '微信昵称',order: 6,view: 'text', type: 'string',},
  //lastOrderTime: {title: '最后报单时间',order: 7,view: 'datetime', type: 'string',},
  status: {title: '状态',order: 8,view: 'number', type: 'number',dictCode: 'upoder_user_status',},
  headImage: {title: '头像',order: 9,view: 'image', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}
