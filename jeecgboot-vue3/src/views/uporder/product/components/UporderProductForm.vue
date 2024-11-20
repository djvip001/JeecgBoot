<template>
  <div>
    <BasicForm @register="registerForm" ref="formRef"/>
  <!-- 子表单区域 -->
    <a-tabs v-model:activeKey="activeKey" animated @change="handleChangeTabs">
      <a-tab-pane tab="产品文本表" key="uporderProductMediumText" :forceRender="true">
        <UporderProductMediumTextForm ref="uporderProductMediumTextForm" :disabled="formDisabled"></UporderProductMediumTextForm>
      </a-tab-pane>

      <a-tab-pane tab="产品用户类型折扣表" key="uporderProductTypeRefundConfig" :forceRender="true">
        <JVxeTable
          v-if="uporderProductTypeRefundConfigTable.show"      
          keep-source
          resizable
          ref="uporderProductTypeRefundConfig"
          :loading="uporderProductTypeRefundConfigTable.loading"
          :columns="uporderProductTypeRefundConfigTable.columns"
          :dataSource="uporderProductTypeRefundConfigTable.dataSource"
          :height="340"
          :disabled="formDisabled"
          :rowNumber="true"
          :rowSelection="true"
          :toolbar="true"
          />
      </a-tab-pane>
    </a-tabs>
    <div style="width: 100%;text-align: center;margin-top: 10px;" v-if="showFlowSubmitButton">
      <a-button preIcon="ant-design:check-outlined" style="width: 126px" type="primary" @click="handleSubmit">提 交</a-button>
    </div>
  </div>
</template>

<script lang="ts" setup>
    import { defHttp } from '/@/utils/http/axios';
    import {ref, computed, unref,reactive, onMounted, defineProps } from 'vue';
    import {BasicForm, useForm} from '/@/components/Form/index';
    import { JVxeTable } from '/@/components/jeecg/JVxeTable'
    import { useJvxeMethod } from '/@/hooks/system/useJvxeMethods.ts'
    import UporderProductMediumTextForm from './UporderProductMediumTextForm.vue'
    import {formSchema,uporderProductTypeRefundConfigJVxeColumns} from '../UporderProduct.data';
    import {saveOrUpdate,queryUporderProductMediumText,queryUporderProductTypeRefundConfig} from '../UporderProduct.api';
    import { VALIDATE_FAILED } from '/@/utils/common/vxeUtils'
    const isUpdate = ref(true);
    
    const refKeys = ref(['uporderProductMediumText', 'uporderProductTypeRefundConfig', ]);
    const activeKey = ref('uporderProductMediumText');
    const uporderProductMediumTextForm = ref();
    const uporderProductTypeRefundConfig = ref();
    const tableRefs = {uporderProductTypeRefundConfig, };
    const uporderProductTypeRefundConfigTable = reactive({
          loading: false,
          dataSource: [],
          columns:uporderProductTypeRefundConfigJVxeColumns,
          show: false
    })

    const props = defineProps({
      formData: { type: Object, default: ()=>{} },
      formBpm: { type: Boolean, default: true }
    });
    const formDisabled = computed(()=>{
      if(props.formBpm === true){
        if(props.formData.disabled === false){
          return false;
        }
      }
      return true;
    });
    // 是否显示提交按钮
    const showFlowSubmitButton = computed(()=>{
      if(props.formBpm === true){
        if(props.formData.disabled === false){
          return true
        }
      }
      return false
    });
    
    //表单配置
    const [registerForm, {setProps,resetFields, setFieldsValue, validate}] = useForm({
        labelWidth: 150,
        schemas: formSchema,
        showActionButtonGroup: false,
        baseColProps: {span: 12}
    });

    onMounted(()=>{
      initFormData();
    });
    //渲染流程表单数据
    const queryByIdUrl = '/product/uporderProduct/queryById';
    async function initFormData(){
      if(props.formBpm === true){
        await reset();
        let params = {id: props.formData.dataId};
        const data = await defHttp.get({url: queryByIdUrl, params});
        //表单赋值
        await setFieldsValue({
          ...data
        });
        uporderProductMediumTextForm.value.initFormData(queryUporderProductMediumText, data.id)
        requestSubTableData(queryUporderProductTypeRefundConfig, {id: data.id}, uporderProductTypeRefundConfigTable, ()=>{
          uporderProductTypeRefundConfigTable.show = true;
        });
        // 隐藏底部时禁用整个表单
        setProps({ disabled: formDisabled.value })
      }
    }
    
    //方法配置
    const [handleChangeTabs,handleSubmit,requestSubTableData,formRef] = useJvxeMethod(requestAddOrEdit,classifyIntoFormData,tableRefs,activeKey,refKeys,validateSubForm);

    async function reset(){
      await resetFields();
      activeKey.value = 'uporderProductMediumText';
      uporderProductMediumTextForm.value.resetFields();
      uporderProductTypeRefundConfigTable.dataSource = [];
    }
    function classifyIntoFormData(allValues) {
         let main = Object.assign({}, allValues.formValue)
         return {
           ...main, // 展开
           uporderProductMediumTextList: uporderProductMediumTextForm.value.getFormData(),
           uporderProductTypeRefundConfigList: allValues.tablesValue[0].tableData,
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
                 } else {
                     console.error(e)
                 }
             })
         })
     }
    //表单提交事件
    async function requestAddOrEdit(values) {
      //提交表单
      await saveOrUpdate(values, true);
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