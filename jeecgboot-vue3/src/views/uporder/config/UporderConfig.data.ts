import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
import { getWeekMonthQuarterYear } from '/@/utils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '平台名称',
    align:"center",
    dataIndex: 'platformName'
   },
   {
    title: '上级名',
    align:"center",
    dataIndex: 'upperName'
   },
   {
    title: '报单账号',
    align:"center",
    dataIndex: 'reportAccount'
   },
   {
    title: '主页',
    align:"center",
    dataIndex: 'upperHome'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '平台名称',
    field: 'platformName',
    component: 'Input',
  },
  {
    label: '上级名',
    field: 'upperName',
    component: 'Input',
  },
  {
    label: '报单账号',
    field: 'reportAccount',
    component: 'Input',
  },
  {
    label: '报单密码',
    field: 'reportPassword',
    component: 'Input',
  },
  {
    label: '主页',
    field: 'upperHome',
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

// 高级查询数据
export const superQuerySchema = {
  platformName: {title: '平台名称',order: 0,view: 'text', type: 'string',},
  upperName: {title: '上级名',order: 1,view: 'text', type: 'string',},
  reportAccount: {title: '报单账号',order: 2,view: 'text', type: 'string',},
  upperHome: {title: '主页',order: 4,view: 'text', type: 'string',},
};

/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}