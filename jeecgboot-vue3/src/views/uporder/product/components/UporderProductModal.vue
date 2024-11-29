<template>
  <BasicModal v-bind="$attrs" @register="registerModal" destroyOnClose :title="title" :width="896" @ok="handleSubmit">
    <BasicForm @register="registerForm" ref="formRef" name="UporderProductForm"/>
    <!-- 子表单区域 -->
    <a-tabs v-model:activeKey="activeKey" animated @change="handleChangeTabs">
      <a-tab-pane tab="产品文本表" key="uporderProductMediumText" :forceRender="true">
        <UporderProductMediumTextForm ref="uporderProductMediumTextForm" :disabled="formDisabled"></UporderProductMediumTextForm>
      </a-tab-pane>

      <a-tab-pane tab="产品用户类型折扣表" key="uporderProductTypeRefundConfig" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="uporderProductTypeRefundConfig"
          :loading="uporderProductTypeRefundConfigTable.loading"
          :columns="uporderProductTypeRefundConfigTable.columns"
          :dataSource="uporderProductTypeRefundConfigTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="true"
          />
      </a-tab-pane>
      <a-tab-pane tab="产品自定义字段表" key="uporderProductDefineField" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="uporderProductDefineField"
          :loading="uporderProductDefineFieldTable.loading"
          :columns="uporderProductDefineFieldTable.columns"
          :dataSource="uporderProductDefineFieldTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="true"
          />
      </a-tab-pane>
      <a-tab-pane tab="报单产品用户额度表" key="uporderProductUserLimit" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="uporderProductUserLimit"
          :loading="uporderProductUserLimitTable.loading"
          :columns="uporderProductUserLimitTable.columns"
          :dataSource="uporderProductUserLimitTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="true"
          />
      </a-tab-pane>
      <a-tab-pane tab="报单产品购买链接" key="uporderProductBuyLink" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="uporderProductBuyLink"
          :loading="uporderProductBuyLinkTable.loading"
          :columns="uporderProductBuyLinkTable.columns"
          :dataSource="uporderProductBuyLinkTable.dataSource"
          :height="340"
          :rowNumber="true"
          :rowSelection="true"
          :disabled="formDisabled"
          :toolbar="true"
          />
      </a-tab-pane>
    </a-tabs>
  </BasicModal>
</template>

<script lang="ts" setup>
    import {ref, computed, unref,reactive} from 'vue';
    import {BasicModal, useModalInner} from '/@/components/Modal';
    import {BasicForm, useForm} from '/@/components/Form/index';
    import { JVxeTable } from '/@/components/jeecg/JVxeTable'
    import { useJvxeMethod } from '/@/hooks/system/useJvxeMethods.ts'
    import UporderProductMediumTextForm from './UporderProductMediumTextForm.vue'
    import {formSchema,uporderProductTypeRefundConfigColumns,uporderProductDefineFieldColumns,uporderProductUserLimitColumns,uporderProductBuyLinkColumns} from '../UporderProduct.data';
    import {saveOrUpdate,uporderProductMediumTextList,uporderProductTypeRefundConfigList,uporderProductDefineFieldList,uporderProductUserLimitList,uporderProductBuyLinkList} from '../UporderProduct.api';
    import { VALIDATE_FAILED } from '/@/utils/common/vxeUtils'
    // Emits声明
    const emit = defineEmits(['register','success']);
    const isUpdate = ref(true);
    const formDisabled = ref(false);
    const refKeys = ref(['uporderProductMediumText', 'uporderProductTypeRefundConfig', 'uporderProductDefineField', 'uporderProductUserLimit', 'uporderProductBuyLink', ]);
    const activeKey = ref('uporderProductMediumText');
    const uporderProductMediumTextForm = ref();
    const uporderProductTypeRefundConfig = ref();
    const uporderProductDefineField = ref();
    const uporderProductUserLimit = ref();
    const uporderProductBuyLink = ref();
    const tableRefs = {uporderProductTypeRefundConfig, uporderProductDefineField, uporderProductUserLimit, uporderProductBuyLink, };
    const uporderProductTypeRefundConfigTable = reactive({
          loading: false,
          dataSource: [],
          columns:uporderProductTypeRefundConfigColumns
    })
    const uporderProductDefineFieldTable = reactive({
          loading: false,
          dataSource: [],
          columns:uporderProductDefineFieldColumns
    })
    const uporderProductUserLimitTable = reactive({
          loading: false,
          dataSource: [],
          columns:uporderProductUserLimitColumns
    })
    const uporderProductBuyLinkTable = reactive({
          loading: false,
          dataSource: [],
          columns:uporderProductBuyLinkColumns
    })
    //表单配置
    const [registerForm, {setProps,resetFields, setFieldsValue, validate}] = useForm({
        schemas: formSchema,
        showActionButtonGroup: false,
        baseColProps: {span: 12}
    });
     //表单赋值
    const [registerModal, {setModalProps, closeModal}] = useModalInner(async (data) => {
        //重置表单
        await reset();
        setModalProps({confirmLoading: false,showCancelBtn:data?.showFooter,showOkBtn:data?.showFooter});
        isUpdate.value = !!data?.isUpdate;
        formDisabled.value = !data?.showFooter;
        if (unref(isUpdate)) {
            //表单赋值
            await setFieldsValue({
                ...data.record,
            });
             uporderProductMediumTextForm.value.initFormData(uporderProductMediumTextList,data?.record?.id)
             requestSubTableData(uporderProductTypeRefundConfigList, {id:data?.record?.id}, uporderProductTypeRefundConfigTable)
             requestSubTableData(uporderProductDefineFieldList, {id:data?.record?.id}, uporderProductDefineFieldTable)
             requestSubTableData(uporderProductUserLimitList, {id:data?.record?.id}, uporderProductUserLimitTable)
             requestSubTableData(uporderProductBuyLinkList, {id:data?.record?.id}, uporderProductBuyLinkTable)
        }
        // 隐藏底部时禁用整个表单
       setProps({ disabled: !data?.showFooter })
    });
    //方法配置
    const [handleChangeTabs,handleSubmit,requestSubTableData,formRef] = useJvxeMethod(requestAddOrEdit,classifyIntoFormData,tableRefs,activeKey,refKeys,validateSubForm);

    //设置标题
    const title = computed(() => (!unref(isUpdate) ? '新增' : !unref(formDisabled) ? '编辑' : '详情'));

    async function reset(){
      await resetFields();
      activeKey.value = 'uporderProductMediumText';
      uporderProductMediumTextForm.value.resetFields();
      uporderProductTypeRefundConfigTable.dataSource = [];
      uporderProductDefineFieldTable.dataSource = [];
      uporderProductUserLimitTable.dataSource = [];
      uporderProductBuyLinkTable.dataSource = [];
    }
    function classifyIntoFormData(allValues) {
         let main = Object.assign({}, allValues.formValue)
         return {
           ...main, // 展开
           uporderProductMediumTextList: uporderProductMediumTextForm.value.getFormData(),
           uporderProductTypeRefundConfigList: allValues.tablesValue[0].tableData,
           uporderProductDefineFieldList: allValues.tablesValue[1].tableData,
           uporderProductUserLimitList: allValues.tablesValue[2].tableData,
           uporderProductBuyLinkList: allValues.tablesValue[3].tableData,
         }
       }
     //校验所有一对一子表表单
     function validateSubForm(allValues){
         return new Promise((resolve,reject)=>{
             Promise.all([
                  uporderProductMediumTextForm.value.validateForm(0),
             ]).then(() => {
                 resolve(allValues)
             }).catch(e => {
                 if (e.error === VALIDATE_FAILED) {
                     // 如果有未通过表单验证的子表，就自动跳转到它所在的tab
                     activeKey.value = e.index == null ? unref(activeKey) : refKeys.value[e.index]
                     if (e.errorFields) {
                       const firstField = e.errorFields[0];
                       if (firstField) {
                         e.scrollToField(firstField.name, { behavior: 'smooth', block: 'center' });
                       }
                     }
                 } else {
                     console.error(e)
                 }
             })
         })
     }
    //表单提交事件
    async function requestAddOrEdit(values) {
        try {
            setModalProps({confirmLoading: true});
            //提交表单
            await saveOrUpdate(values, isUpdate.value);
            //关闭弹窗
            closeModal();
            //刷新列表
            emit('success');
        } finally {
            setModalProps({confirmLoading: false});
        }
    }
</script>

<style lang="less" scoped>
	/** 时间和数字输入框样式 */
  :deep(.ant-input-number) {
    width: 100%;
  }

  :deep(.ant-calendar-picker) {
    width: 100%;
  }
</style>