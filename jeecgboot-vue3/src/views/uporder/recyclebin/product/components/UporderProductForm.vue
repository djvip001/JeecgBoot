<template>
  <div>
    <BasicForm @register="registerForm" ref="formRef"/>
    <!-- 子表单区域 -->
    <a-tabs v-model:activeKey="activeKey" animated  @change="handleChangeTabs">
      <a-tab-pane tab="产品文本表" key="uporderProductMediumText" :forceRender="true">
        <UporderProductMediumTextForm ref="uporderProductMediumTextForm" :disabled="formDisabled"></UporderProductMediumTextForm>
      </a-tab-pane>
      <a-tab-pane tab="产品用户类型折扣表" key="uporderProductTypeRefundConfig" :forceRender="true">
        <JVxeTable
          keep-source
          resizable
          ref="uporderProductTypeRefundConfig"
          v-if="uporderProductTypeRefundConfigTable.show"
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
          v-if="uporderProductDefineFieldTable.show"
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
          v-if="uporderProductUserLimitTable.show"
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
          v-if="uporderProductBuyLinkTable.show"
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

    <div style="width: 100%;text-align: center" v-if="!formDisabled">
      <a-button @click="handleSubmit" pre-icon="ant-design:check" type="primary">提 交</a-button>
    </div>
  </div>
</template>

<script lang="ts">

  import {BasicForm, useForm} from '/@/components/Form/index';
  import { computed, defineComponent, reactive, ref, unref } from 'vue';
  import {defHttp} from '/@/utils/http/axios';
  import { propTypes } from '/@/utils/propTypes';
  import { useJvxeMethod } from '/@/hooks/system/useJvxeMethods';
  import { VALIDATE_FAILED } from '/@/utils/common/vxeUtils';
  import UporderProductMediumTextForm from './UporderProductMediumTextForm.vue'
  import {getBpmFormSchema,uporderProductTypeRefundConfigColumns,uporderProductDefineFieldColumns,uporderProductUserLimitColumns,uporderProductBuyLinkColumns} from '../UporderProduct.data';
  import {saveOrUpdate,uporderProductMediumTextList,uporderProductTypeRefundConfigList,uporderProductDefineFieldList,uporderProductUserLimitList,uporderProductBuyLinkList} from '../UporderProduct.api';

  export default defineComponent({
    name: "UporderProductForm",
    components:{
      BasicForm,
      UporderProductMediumTextForm,
    },
    props:{
      formData: propTypes.object.def({}),
      formBpm: propTypes.bool.def(true),
    },
    setup(props){
      const [registerForm, { setFieldsValue, setProps }] = useForm({
        labelWidth: 150,
        schemas: getBpmFormSchema(props.formData),
        showActionButtonGroup: false,
        baseColProps: {span: 8}
      });

      const formDisabled = computed(()=>{
        if(props.formData.disabled === false){
          return false;
        }
        return true;
      });

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
        columns:uporderProductTypeRefundConfigColumns,
        show: false
      })
      const uporderProductDefineFieldTable = reactive({
        loading: false,
        dataSource: [],
        columns:uporderProductDefineFieldColumns,
        show: false
      })
      const uporderProductUserLimitTable = reactive({
        loading: false,
        dataSource: [],
        columns:uporderProductUserLimitColumns,
        show: false
      })
      const uporderProductBuyLinkTable = reactive({
        loading: false,
        dataSource: [],
        columns:uporderProductBuyLinkColumns,
        show: false
      })

      const [handleChangeTabs,handleSubmit,requestSubTableData,formRef] = useJvxeMethod(requestAddOrEdit,classifyIntoFormData,tableRefs,activeKey,refKeys,validateSubForm);

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
        return new Promise((resolve, _reject)=>{
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
        await saveOrUpdate(values, true);
      }

      const queryByIdUrl = '/product/uporderProduct/queryById';
      async function initFormData(){
        let params = {id: props.formData.dataId};
        const data = await defHttp.get({url: queryByIdUrl, params});
        //设置表单的值
        await setFieldsValue({...data});
        uporderProductMediumTextForm.value.initFormData(uporderProductMediumTextList, data.id);
        requestSubTableData(uporderProductTypeRefundConfigList, {id: data.id}, uporderProductTypeRefundConfigTable, ()=>{
          uporderProductTypeRefundConfigTable.show = true;
        });
        requestSubTableData(uporderProductDefineFieldList, {id: data.id}, uporderProductDefineFieldTable, ()=>{
          uporderProductDefineFieldTable.show = true;
        });
        requestSubTableData(uporderProductUserLimitList, {id: data.id}, uporderProductUserLimitTable, ()=>{
          uporderProductUserLimitTable.show = true;
        });
        requestSubTableData(uporderProductBuyLinkList, {id: data.id}, uporderProductBuyLinkTable, ()=>{
          uporderProductBuyLinkTable.show = true;
        });
        //默认是禁用
        await setProps({disabled: formDisabled.value})
      }

      initFormData();

      return {
        registerForm,
        formDisabled,
        formRef,
        handleSubmit,
        activeKey,
        handleChangeTabs,
        uporderProductMediumTextForm,
        uporderProductTypeRefundConfig,
        uporderProductDefineField,
        uporderProductUserLimit,
        uporderProductBuyLink,
        uporderProductTypeRefundConfigTable,
        uporderProductDefineFieldTable,
        uporderProductUserLimitTable,
        uporderProductBuyLinkTable,
      }
    }
  });
</script>