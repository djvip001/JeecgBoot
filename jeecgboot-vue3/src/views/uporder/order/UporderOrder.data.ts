import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import {JVxeTypes,JVxeColumn} from '/@/components/jeecg/JVxeTable/types'
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '报单人账号',
    align:"center",
    dataIndex: 'account'
   },
   {
    title: '产品id',
    align:"center",
    dataIndex: 'productId'
   },
   {
    title: '数量',
    align:"center",
    dataIndex: 'mcount'
   },
   {
    title: '报单金额',
    align:"center",
    dataIndex: 'price'
   },
   {
    title: '订单号',
    align:"center",
    dataIndex: 'orderNo'
   },
   {
    title: '备注',
    align:"center",
    dataIndex: 'customerNote'
   },
   {
    title: '订单图',
    align:"center",
    dataIndex: 'imgPath'
   },
   {
    title: '评价图',
    align:"center",
    dataIndex: 'commentImg'
   },
   {
    title: '尾款图',
    align:"center",
    dataIndex: 'finalPayImg'
   },
   {
    title: '完成图',
    align:"center",
    dataIndex: 'orderCompleteImg'
   },
   {
    title: '订单状态',
    align:"center",
    dataIndex: 'orderStatus_dictText'
   },
   {
    title: '上级单状态',
    align:"center",
    dataIndex: 'upperOrderStatus_dictText'
   },
   {
    title: '渠道状态',
    align:"center",
    dataIndex: 'upperChannelStatus_dictText'
   },
   {
    title: '实付金额',
    align:"center",
    dataIndex: 'actualPayMoney'
   },
   {
    title: '折扣',
    align:"center",
    dataIndex: 'discount'
   },
   {
    title: '税率',
    align:"center",
    dataIndex: 'taxRate'
   },
   {
    title: '税费',
    align:"center",
    dataIndex: 'taxFee'
   },
   {
    title: '返款计算方式',
    align:"center",
    dataIndex: 'refundCalWay_dictText'
   },
   {
    title: '返款额',
    align:"center",
    dataIndex: 'refundMoney'
   },
   {
    title: '进价计算方式',
    align:"center",
    dataIndex: 'inRefundCalWay_dictText'
   },
   {
    title: '进价折扣',
    align:"center",
    dataIndex: 'inDiscount'
   },
   {
    title: '上级返款',
    align:"center",
    dataIndex: 'inFefundMoney'
   },
   {
    title: '利润',
    align:"center",
    dataIndex: 'profit'
   },
   {
    title: '付款时间',
    align:"center",
    dataIndex: 'payTime'
   },
   {
    title: '报单给上级时间',
    align:"center",
    dataIndex: 'reportUpperTime'
   },
   {
    title: '向上级申请返款时间',
    align:"center",
    dataIndex: 'refundUpperTime'
   },
   {
    title: '上级返款时间',
    align:"center",
    dataIndex: 'inRefundTime'
   },
   {
    title: '上级打款方式',
    align:"center",
    dataIndex: 'inRefundPayWay_dictText'
   },
   {
    title: '上级打款备注',
    align:"center",
    dataIndex: 'inFefundNote'
   },
   {
    title: '返款申请时间',
    align:"center",
    dataIndex: 'refundSubmitTime'
   },
   {
    title: '预计打款时间',
    align:"center",
    dataIndex: 'estimatePaymentTime',
    customRender:({text}) =>{
      text = !text ? "" : (text.length > 10 ? text.substr(0,10) : text);
      return text;
    },
   },
   {
    title: '创建人',
    align:"center",
    dataIndex: 'createBy'
   },
   {
    title: '创建日期',
    align:"center",
    dataIndex: 'createTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '产品id',
    field: 'productId',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入产品id!'},
          ];
     },
  },
  {
    label: '报单金额',
    field: 'price',
    component: 'InputNumber',
  },
  {
    label: '订单号',
    field: 'orderNo',
    component: 'Input',
  },
  {
    label: '备注',
    field: 'customerNote',
    component: 'Input',
  },
  {
    label: '订单图',
    field: 'imgPath',
    component: 'Input',
  },
  {
    label: '评价图',
    field: 'commentImg',
    component: 'Input',
  },
  {
    label: '尾款图',
    field: 'finalPayImg',
    component: 'Input',
  },
  {
    label: '完成图',
    field: 'orderCompleteImg',
    component: 'Input',
  },
  {
    label: '订单状态',
    field: 'orderStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"up_order_status"
     },
  },
  {
    label: '上级单状态',
    field: 'upperOrderStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"up_order_status"
     },
  },
  {
    label: '渠道状态',
    field: 'upperChannelStatus',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"upper_channel_status"
     },
  },
  {
    label: '实付金额',
    field: 'actualPayMoney',
    component: 'InputNumber',
  },
  {
    label: '折扣',
    field: 'discount',
    component: 'InputNumber',
  },
  {
    label: '税率',
    field: 'taxRate',
    component: 'InputNumber',
  },
  {
    label: '税费',
    field: 'taxFee',
    component: 'InputNumber',
  },
  {
    label: '返款计算方式',
    field: 'refundCalWay',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"refund_cal_way"
     },
  },
  {
    label: '返款额',
    field: 'refundMoney',
    component: 'InputNumber',
  },
  {
    label: '进价计算方式',
    field: 'inRefundCalWay',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"refund_cal_way"
     },
  },
  {
    label: '进价折扣',
    field: 'inDiscount',
    component: 'InputNumber',
  },
  {
    label: '上级返款',
    field: 'inFefundMoney',
    component: 'InputNumber',
  },
  {
    label: '利润',
    field: 'profit',
    component: 'InputNumber',
  },
  {
    label: '付款时间',
    field: 'payTime',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '报单给上级时间',
    field: 'reportUpperTime',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '向上级申请返款时间',
    field: 'refundUpperTime',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '上级返款时间',
    field: 'inRefundTime',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '上级打款方式',
    field: 'inRefundPayWay',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"refund_pay_way"
     },
  },
  {
    label: '上级打款备注',
    field: 'inFefundNote',
    component: 'Input',
  },
  {
    label: '返款申请时间',
    field: 'refundSubmitTime',
    component: 'DatePicker',
    componentProps: {
       showTime:true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '预计打款时间',
    field: 'estimatePaymentTime',
    component: 'DatePicker',
    componentProps:{
      valueFormat: 'YYYY-MM-DD'
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
//子表单数据
//子表表格配置
export const uporderOrderTrafficNoColumns: JVxeColumn[] = [
    {
      title: '订单id',
      key: 'orderId',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '物流单号',
      key: 'trafficOrderNo',
      type: JVxeTypes.input,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
    {
      title: '状态',
      key: 'trafficStatus',
      type: JVxeTypes.inputNumber,
      width:"200px",
      placeholder: '请输入${title}',
      defaultValue:'',
    },
  ]


// 高级查询数据
export const superQuerySchema = {
  account: {title: '报单人账号',order: 0,view: 'text', type: 'string',},
  productId: {title: '产品id',order: 1,view: 'text', type: 'string',},
  mcount: {title: '数量',order: 2,view: 'number', type: 'number',},
  price: {title: '报单金额',order: 3,view: 'number', type: 'number',},
  orderNo: {title: '订单号',order: 4,view: 'text', type: 'string',},
  customerNote: {title: '备注',order: 5,view: 'text', type: 'string',},
  imgPath: {title: '订单图',order: 6,view: 'text', type: 'string',},
  commentImg: {title: '评价图',order: 7,view: 'text', type: 'string',},
  finalPayImg: {title: '尾款图',order: 8,view: 'text', type: 'string',},
  orderCompleteImg: {title: '完成图',order: 9,view: 'text', type: 'string',},
  orderStatus: {title: '订单状态',order: 10,view: 'number', type: 'number',dictCode: 'up_order_status',},
  upperOrderStatus: {title: '上级单状态',order: 11,view: 'number', type: 'number',dictCode: 'up_order_status',},
  upperChannelStatus: {title: '渠道状态',order: 12,view: 'number', type: 'number',dictCode: 'upper_channel_status',},
  actualPayMoney: {title: '实付金额',order: 13,view: 'number', type: 'number',},
  discount: {title: '折扣',order: 14,view: 'number', type: 'number',},
  taxRate: {title: '税率',order: 15,view: 'number', type: 'number',},
  taxFee: {title: '税费',order: 16,view: 'number', type: 'number',},
  refundCalWay: {title: '返款计算方式',order: 17,view: 'number', type: 'number',dictCode: 'refund_cal_way',},
  refundMoney: {title: '返款额',order: 18,view: 'number', type: 'number',},
  inRefundCalWay: {title: '进价计算方式',order: 19,view: 'number', type: 'number',dictCode: 'refund_cal_way',},
  inDiscount: {title: '进价折扣',order: 20,view: 'number', type: 'number',},
  inFefundMoney: {title: '上级返款',order: 21,view: 'number', type: 'number',},
  profit: {title: '利润',order: 22,view: 'number', type: 'number',},
  payTime: {title: '付款时间',order: 23,view: 'datetime', type: 'string',},
  reportUpperTime: {title: '报单给上级时间',order: 24,view: 'datetime', type: 'string',},
  refundUpperTime: {title: '向上级申请返款时间',order: 25,view: 'datetime', type: 'string',},
  inRefundTime: {title: '上级返款时间',order: 26,view: 'datetime', type: 'string',},
  inRefundPayWay: {title: '上级打款方式',order: 27,view: 'number', type: 'number',dictCode: 'refund_pay_way',},
  inFefundNote: {title: '上级打款备注',order: 28,view: 'text', type: 'string',},
  refundSubmitTime: {title: '返款申请时间',order: 29,view: 'datetime', type: 'string',},
  estimatePaymentTime: {title: '预计打款时间',order: 30,view: 'date', type: 'string',},
  createBy: {title: '创建人',order: 31,view: 'text', type: 'string',},
  createTime: {title: '创建日期',order: 32,view: 'datetime', type: 'string',},
  //子表高级查询
  uporderOrderTrafficNo: {
    title: '订单物流表',
    view: 'table',
    fields: {
        trafficOrderNo: {title: '物流单号',order: 1,view: 'text', type: 'string',},
        trafficStatus: {title: '状态',order: 2,view: 'number', type: 'number',},
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