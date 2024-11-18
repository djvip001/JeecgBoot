<template>
    <view>
        <!--标题和返回-->
		<cu-custom :bgColor="NavBarColor" isBack :backRouterName="backRouteName">
			<block slot="backText">返回</block>
			<block slot="content">产品表</block>
		</cu-custom>
		 <!--表单区域-->
		<view>
			<form>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">项目：</text></view>
                  <input  placeholder="请输入项目" v-model="model.projectId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">产品名：</text></view>
                  <input  placeholder="请输入产品名" v-model="model.productName"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">总额度：</text></view>
                  <input type="number" placeholder="请输入总额度" v-model="model.totalLimitMoney"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">购买链接：</text></view>
                  <input  placeholder="请输入购买链接" v-model="model.buyUrl"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">描述：</text></view>
                  <input  placeholder="请输入描述" v-model="model.description"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">管理员备注：</text></view>
                  <input  placeholder="请输入管理员备注" v-model="model.note"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">剩余额度：</text></view>
                  <input type="number" placeholder="请输入剩余额度" v-model="model.leftLimitMoney"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">返款计算方式：</text></view>
                  <input type="number" placeholder="请输入返款计算方式" v-model="model.inRefundCalWay"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">默认成本：</text></view>
                  <input type="number" placeholder="请输入默认成本" v-model="model.discount"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">税率：</text></view>
                  <input type="number" placeholder="请输入税率" v-model="model.taxRate"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">进价成本：</text></view>
                  <input type="number" placeholder="请输入进价成本" v-model="model.inDiscount"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">报单上级：</text></view>
                  <input  placeholder="请输入报单上级" v-model="model.upperConfigId"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">上级报单链接：</text></view>
                  <input  placeholder="请输入上级报单链接" v-model="model.upperReportUrl"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否跟上级额度：</text></view>
                  <input  placeholder="请输入是否跟上级额度" v-model="model.validUpperLimit"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">关闭自动推单：</text></view>
                  <input  placeholder="请输入关闭自动推单" v-model="model.closeAutoPush"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">关闭自动申请返款：</text></view>
                  <input  placeholder="请输入关闭自动申请返款" v-model="model.closeAutoRefund"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">上架状态：</text></view>
                  <input  placeholder="请输入上架状态" v-model="model.shelf"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否显示配额：</text></view>
                  <input  placeholder="请输入是否显示配额" v-model="model.showQuota"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否活动页显示：</text></view>
                  <input  placeholder="请输入是否活动页显示" v-model="model.showAct"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否预售：</text></view>
                  <input  placeholder="请输入是否预售" v-model="model.presale"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否收集评价图：</text></view>
                  <input  placeholder="请输入是否收集评价图" v-model="model.collectEvaluateImg"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否收集物流单号：</text></view>
                  <input  placeholder="请输入是否收集物流单号" v-model="model.collectTrafficNo"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否刷货产品：</text></view>
                  <input  placeholder="请输入是否刷货产品" v-model="model.shuahuo"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">是否完结：</text></view>
                  <input  placeholder="请输入是否完结" v-model="model.settlement"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">最大报单时间：</text></view>
                  <input type="number" placeholder="请输入最大报单时间" v-model="model.maxReportInterval"/>
                </view>
              </view>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">隐藏字段：</text></view>
                  <input  placeholder="请输入隐藏字段" v-model="model.reportHiddenFields"/>
                </view>
              </view>
              <my-date label="开始报单时间：" v-model="model.starTime" placeholder="请输入开始报单时间"></my-date>
              <my-date label="结束报单时间：" v-model="model.endTime" placeholder="请输入结束报单时间"></my-date>
              <view class="cu-form-group">
                <view class="flex align-center">
                  <view class="title"><text space="ensp">返款规则：</text></view>
                  <input  placeholder="请输入返款规则" v-model="model.refundRule"/>
                </view>
              </view>
				<view class="padding">
					<button class="cu-btn block bg-blue margin-tb-sm lg" @click="onSubmit">
						<text v-if="loading" class="cuIcon-loading2 cuIconfont-spin"></text>提交
					</button>
				</view>
			</form>
		</view>
    </view>
</template>

<script>
    import myDate from '@/components/my-componets/my-date.vue'

    export default {
        name: "UporderProductForm",
        components:{ myDate },
        props:{
          formData:{
              type:Object,
              default:()=>{},
              required:false
          }
        },
        data(){
            return {
				CustomBar: this.CustomBar,
				NavBarColor: this.NavBarColor,
				loading:false,
                model: {},
                backRouteName:'index',
                url: {
                  queryById: "/product/uporderProduct/queryById",
                  add: "/product/uporderProduct/add",
                  edit: "/product/uporderProduct/edit",
                },
            }
        },
        created(){
             this.initFormData();
        },
        methods:{
           initFormData(){
               if(this.formData){
                    let dataId = this.formData.dataId;
                    this.$http.get(this.url.queryById,{params:{id:dataId}}).then((res)=>{
                        if(res.data.success){
                            console.log("表单数据",res);
                            this.model = res.data.result;
                        }
                    })
                }
            },
            onSubmit() {
                let myForm = {...this.model};
                this.loading = true;
                let url = myForm.id?this.url.edit:this.url.add;
				this.$http.post(url,myForm).then(res=>{
				   console.log("res",res)
				   this.loading = false
				   this.$Router.push({name:this.backRouteName})
				}).catch(()=>{
					this.loading = false
				});
            }
        }
    }
</script>
