<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="商家ID" prop="merchantId">
      <el-input v-model="dataForm.merchantId" placeholder="商家ID"></el-input>
    </el-form-item>
    <el-form-item label="广告ID" prop="adId">
      <el-input v-model="dataForm.adId" placeholder="广告ID"></el-input>
    </el-form-item>
    <el-form-item label="推送次数" prop="impressions">
      <el-input v-model="dataForm.impressions" placeholder="推送次数"></el-input>
    </el-form-item>
    <el-form-item label="点击次数" prop="clicks">
      <el-input v-model="dataForm.clicks" placeholder="点击次数"></el-input>
    </el-form-item>
    <el-form-item label="单价（每次推送）" prop="pricePerImpression">
      <el-input v-model="dataForm.pricePerImpression" placeholder="单价（每次推送）"></el-input>
    </el-form-item>
    <el-form-item label="总费用" prop="totalCost">
      <el-input v-model="dataForm.totalCost" placeholder="总费用"></el-input>
    </el-form-item>
    <el-form-item label="付款状态" prop="paymentStatus">
      <el-input v-model="dataForm.paymentStatus" placeholder="付款状态"></el-input>
    </el-form-item>
    <el-form-item label="创建时间" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder="创建时间"></el-input>
    </el-form-item>
    <el-form-item label="创建者用户ID" prop="createdUser">
      <el-input v-model="dataForm.createdUser" placeholder="创建者用户ID"></el-input>
    </el-form-item>
    <el-form-item label="更新时间" prop="updateTime">
      <el-input v-model="dataForm.updateTime" placeholder="更新时间"></el-input>
    </el-form-item>
    <el-form-item label="更新者用户ID" prop="updatedUser">
      <el-input v-model="dataForm.updatedUser" placeholder="更新者用户ID"></el-input>
    </el-form-item>
    <el-form-item label="是否删除（1是，0否）" prop="isDelete">
      <el-input v-model="dataForm.isDelete" placeholder="是否删除（1是，0否）"></el-input>
    </el-form-item>
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">确定</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        dataForm: {
          recordId: 0,
          merchantId: '',
          adId: '',
          impressions: '',
          clicks: '',
          pricePerImpression: '',
          totalCost: '',
          paymentStatus: '',
          createTime: '',
          createdUser: '',
          updateTime: '',
          updatedUser: '',
          isDelete: ''
        },
        dataRule: {
          merchantId: [
            { required: true, message: '商家ID不能为空', trigger: 'blur' }
          ],
          adId: [
            { required: true, message: '广告ID不能为空', trigger: 'blur' }
          ],
          impressions: [
            { required: true, message: '推送次数不能为空', trigger: 'blur' }
          ],
          clicks: [
            { required: true, message: '点击次数不能为空', trigger: 'blur' }
          ],
          pricePerImpression: [
            { required: true, message: '单价（每次推送）不能为空', trigger: 'blur' }
          ],
          totalCost: [
            { required: true, message: '总费用不能为空', trigger: 'blur' }
          ],
          paymentStatus: [
            { required: true, message: '付款状态不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '创建时间不能为空', trigger: 'blur' }
          ],
          createdUser: [
            { required: true, message: '创建者用户ID不能为空', trigger: 'blur' }
          ],
          updateTime: [
            { required: true, message: '更新时间不能为空', trigger: 'blur' }
          ],
          updatedUser: [
            { required: true, message: '更新者用户ID不能为空', trigger: 'blur' }
          ],
          isDelete: [
            { required: true, message: '是否删除（1是，0否）不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.recordId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.recordId) {
            this.$http({
              url: this.$http.adornUrl(`/advertisement/adchargingtable/info/${this.dataForm.recordId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.merchantId = data.adChargingTable.merchantId
                this.dataForm.adId = data.adChargingTable.adId
                this.dataForm.impressions = data.adChargingTable.impressions
                this.dataForm.clicks = data.adChargingTable.clicks
                this.dataForm.pricePerImpression = data.adChargingTable.pricePerImpression
                this.dataForm.totalCost = data.adChargingTable.totalCost
                this.dataForm.paymentStatus = data.adChargingTable.paymentStatus
                this.dataForm.createTime = data.adChargingTable.createTime
                this.dataForm.createdUser = data.adChargingTable.createdUser
                this.dataForm.updateTime = data.adChargingTable.updateTime
                this.dataForm.updatedUser = data.adChargingTable.updatedUser
                this.dataForm.isDelete = data.adChargingTable.isDelete
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/advertisement/adchargingtable/${!this.dataForm.recordId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'recordId': this.dataForm.recordId || undefined,
                'merchantId': this.dataForm.merchantId,
                'adId': this.dataForm.adId,
                'impressions': this.dataForm.impressions,
                'clicks': this.dataForm.clicks,
                'pricePerImpression': this.dataForm.pricePerImpression,
                'totalCost': this.dataForm.totalCost,
                'paymentStatus': this.dataForm.paymentStatus,
                'createTime': this.dataForm.createTime,
                'createdUser': this.dataForm.createdUser,
                'updateTime': this.dataForm.updateTime,
                'updatedUser': this.dataForm.updatedUser,
                'isDelete': this.dataForm.isDelete
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
