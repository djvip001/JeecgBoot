import {defHttp} from '/@/utils/http/axios';
import { useMessage } from "/@/hooks/web/useMessage";

const { createConfirm } = useMessage();

enum Api {
  list = '/product/uporderProduct/list',
  dellist = '/product/uporderProduct/dellist',
  recover='/product/uporderProduct/recover',
  save='/product/uporderProduct/add',
  edit='/product/uporderProduct/edit',
  deleteOne = '/product/uporderProduct/delete',
  deleteBatch = '/product/uporderProduct/deleteBatch',
  importExcel = '/product/uporderProduct/importExcel',
  exportXls = '/product/uporderProduct/exportXls',
  uporderProductMediumTextList = '/product/uporderProduct/queryUporderProductMediumTextByMainId',
  uporderProductTypeRefundConfigList = '/product/uporderProduct/queryUporderProductTypeRefundConfigByMainId',
  uporderProductDefineFieldList = '/product/uporderProduct/queryUporderProductDefineFieldByMainId',
  uporderProductUserLimitList = '/product/uporderProduct/queryUporderProductUserLimitByMainId',
  uporderProductBuyLinkList = '/product/uporderProduct/queryUporderProductBuyLinkByMainId',
}
/**
 * 导出api
 * @param params
 */
export const getExportUrl = Api.exportXls;

/**
 * 导入api
 */
export const getImportUrl = Api.importExcel;
/**
 * 查询子表数据
 * @param params
 */
export const uporderProductMediumTextList = Api.uporderProductMediumTextList;
/**
 * 查询子表数据
 * @param params
 */
export const uporderProductTypeRefundConfigList = Api.uporderProductTypeRefundConfigList;
/**
 * 查询子表数据
 * @param params
 */
export const uporderProductDefineFieldList = Api.uporderProductDefineFieldList;
/**
 * 查询子表数据
 * @param params
 */
export const uporderProductUserLimitList = Api.uporderProductUserLimitList;
/**
 * 查询子表数据
 * @param params
 */
export const uporderProductBuyLinkList = Api.uporderProductBuyLinkList;
/**
 * 列表接口
 * @param params
 */
export const list = (params) =>
  defHttp.get({url: Api.list, params});

/**
 * 删除单个
 */
export const deleteOne = (params,handleSuccess) => {
  return defHttp.delete({url: Api.deleteOne, params}, {joinParamsToUrl: true}).then(() => {
    handleSuccess();
  });
}
/**
 * 批量删除
 * @param params
 */
export const batchDelete = (params, handleSuccess) => {
  createConfirm({
    iconType: 'warning',
    title: '确认删除',
    content: '是否删除选中数据',
    okText: '确认',
    cancelText: '取消',
    onOk: () => {
      return defHttp.delete({url: Api.deleteBatch, data: params}, {joinParamsToUrl: true}).then(() => {
        handleSuccess();
      });
    }
  });
}
/**
 * 保存或者更新
 * @param params
 */
export const saveOrUpdate = (params, isUpdate) => {
  let url = isUpdate ? Api.edit : Api.save;
  return defHttp.post({url: url, params});
}

export const dellist = (params) =>
  defHttp.get({url: Api.dellist, params});

export const recoverData = (params, handleSuccess) => {
  createConfirm({
    iconType: 'warning',
    title: '确认恢复',
    content: '是否恢复选中数据',
    okText: '确认',
    cancelText: '取消',
    onOk: () => {
      return defHttp.post({url: Api.recover, data: params}, {joinParamsToUrl: true}).then(() => {
        handleSuccess();
      });
    }
  });
}
