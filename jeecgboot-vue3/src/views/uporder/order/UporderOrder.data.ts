import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import {JVxeTypes,JVxeColumn} from '/@/components/jeecg/JVxeTable/types'
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '产品id',
    align:"center",
    dataIndex: 'productId_dictText'
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
    dataIndex: 'imgPath',
     customRender:render.renderImage
   },
   {
    title: '评价图',
    align:"center",
    dataIndex: 'commentImg',
     customRender:render.renderImage,
   },
   {
    title: '尾款图',
    align:"center",
    dataIndex: 'finalPayImg',
     customRender:render.renderImage,
   },
   {
    title: '完成图',
    align:"center",
    dataIndex: 'orderCompleteImg',
     customRender:render.renderImage,
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
    title: '实付金额',
    align:"center",
    dataIndex: 'actualPayMoney'
   },
   {
    title: '付款时间',
    align:"center",
    dataIndex: 'payTime'
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
    title: '返款状态',
    align:"center",
    dataIndex: 'refundStatus_dictText'
   },
   {
    title: '返款申请时间',
    align:"center",
    dataIndex: 'refundSubmitTime'
   },
   {
    title: '返款审核时间',
    align:"center",
    dataIndex: 'refundAuditTime'
   },
   {
    title: '返款审核状态',
    align:"center",
    dataIndex: 'auditStatus_dictText'
   },
   {
    title: '返款失败原因',
    align:"center",
    dataIndex: 'auditFailReason'
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
    title: '返款打款方式',
    align:"center",
    dataIndex: 'refundPayWay_dictText'
   },
   {
    title: '返款打款备注',
    align:"center",
    dataIndex: 'refundNote'
   },
   {
    title: '确定打款时间',
    align:"center",
    dataIndex: 'confirmRefundTime'
   },
   {
    title: '进价折扣',
    align:"center",
    dataIndex: 'inDiscount'
   },
   {
    title: '进价计算方式',
    align:"center",
    dataIndex: 'inRefundCalWay_dictText'
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
    title: '渠道状态',
    align:"center",
    dataIndex: 'upperChannelStatus_dictText'
   },
   {
    title: '上级打款方式',
    align:"center",
    dataIndex: 'inRefundPayWay_dictText'
   },
   {
    title: '上级返款时间',
    align:"center",
    dataIndex: 'inRefundTime'
   },
   {
    title: '上级打款备注',
    align:"center",
    dataIndex: 'inRefundNote'
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
	{
      label: "报单人",
      field: "userId",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"uporder_user,account,id"
      },
      //colProps: {span: 6},
 	},
	{
      label: "产品",
      field: "productId",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"uporder_product  where del_flag=0,product_name,id"
      },
      //colProps: {span: 6},
 	},
	{
      label: "报单金额",
      field: "price",
      component: 'InputNumber',
      //colProps: {span: 6},
 	},
	{
      label: "订单号",
      field: "orderNo",
      component: 'Input',
      //colProps: {span: 6},
 	},
	{
      label: "订单状态",
      field: "orderStatus",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"up_order_status"
      },
      //colProps: {span: 6},
 	},
	{
      label: "实付金额",
      field: "actualPayMoney",
      component: 'InputNumber',
      //colProps: {span: 6},
 	},
	{
      label: "折扣",
      field: "discount",
      component: 'InputNumber',
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
      label: "返款状态",
      field: "refundStatus",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"refund_status"
      },
      //colProps: {span: 6},
 	},
	{
      label: "返款审核状态",
      field: "auditStatus",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"audit_status"
      },
      //colProps: {span: 6},
 	},
	{
      label: "返款打款方式",
      field: "refundPayWay",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"refund_pay_way"
      },
      //colProps: {span: 6},
 	},
	{
      label: "渠道状态",
      field: "upperChannelStatus",
      component: 'JSelectMultiple',
      componentProps:{
          dictCode:"upper_channel_status"
      },
      //colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '报单人',
    field: 'userId',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"uporder_user,account,id"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入报单人id!'},
          ];
     },
  },
  {
    label: '产品',
    field: 'productId',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"uporder_product  where del_flag=0,product_name,id"
     },
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
  productId: {title: '产品id',order: 1,view: 'list', type: 'string',dictTable: "uporder_product  where del_flag=0", dictCode: 'id', dictText: 'product_name',},
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
  actualPayMoney: {title: '实付金额',order: 12,view: 'number', type: 'number',},
  payTime: {title: '付款时间',order: 13,view: 'datetime', type: 'string',},
  discount: {title: '折扣',order: 14,view: 'number', type: 'number',},
  taxRate: {title: '税率',order: 15,view: 'number', type: 'number',},
  taxFee: {title: '税费',order: 16,view: 'number', type: 'number',},
  refundCalWay: {title: '返款计算方式',order: 17,view: 'number', type: 'number',dictCode: 'refund_cal_way',},
  refundMoney: {title: '返款额',order: 18,view: 'number', type: 'number',},
  refundStatus: {title: '返款状态',order: 19,view: 'number', type: 'number',dictCode: 'refund_status',},
  refundSubmitTime: {title: '返款申请时间',order: 20,view: 'datetime', type: 'string',},
  refundAuditTime: {title: '返款审核时间',order: 21,view: 'datetime', type: 'string',},
  auditStatus: {title: '返款审核状态',order: 22,view: 'list', type: 'string',dictCode: 'audit_status',},
  auditFailReason: {title: '返款失败原因',order: 23,view: 'text', type: 'string',},
  estimatePaymentTime: {title: '预计打款时间',order: 24,view: 'date', type: 'string',},
  refundPayWay: {title: '返款打款方式',order: 25,view: 'number', type: 'number',dictCode: 'refund_pay_way',},
  refundNote: {title: '返款打款备注',order: 26,view: 'text', type: 'string',},
  confirmRefundTime: {title: '确定打款时间',order: 27,view: 'text', type: 'string',},
  inDiscount: {title: '进价折扣',order: 28,view: 'number', type: 'number',},
  inRefundCalWay: {title: '进价计算方式',order: 29,view: 'number', type: 'number',dictCode: 'refund_cal_way',},
  inFefundMoney: {title: '上级返款',order: 30,view: 'number', type: 'number',},
  profit: {title: '利润',order: 31,view: 'number', type: 'number',},
  upperChannelStatus: {title: '渠道状态',order: 32,view: 'number', type: 'number',dictCode: 'upper_channel_status',},
  inRefundPayWay: {title: '上级打款方式',order: 33,view: 'number', type: 'number',dictCode: 'refund_pay_way',},
  inRefundTime: {title: '上级返款时间',order: 34,view: 'datetime', type: 'string',},
  inRefundNote: {title: '上级打款备注',order: 35,view: 'text', type: 'string',},
  createBy: {title: '创建人',order: 36,view: 'text', type: 'string',},
  createTime: {title: '创建日期',order: 37,view: 'datetime', type: 'string',},
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
