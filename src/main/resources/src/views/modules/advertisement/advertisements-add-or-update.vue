<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="商家ID" prop="merchantId">
      <el-input v-model="dataForm.merchantId" placeholder="商家ID"></el-input>
    </el-form-item>
    <el-form-item label="广告内容" prop="content">
      <el-input v-model="dataForm.content" placeholder="广告内容"></el-input>
    </el-form-item>
    <el-form-item label="广告类型" prop="type">
      <el-input v-model="dataForm.type" placeholder="广告类型"></el-input>
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
          adId: 0,
          merchantId: '',
          content: '',
          type: '',
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
          content: [
            { required: true, message: '广告内容不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '广告类型不能为空', trigger: 'blur' }
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
        this.dataForm.adId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.adId) {
            this.$http({
              url: this.$http.adornUrl(`/advertisement/advertisements/info/${this.dataForm.adId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.merchantId = data.advertisements.merchantId
                this.dataForm.content = data.advertisements.content
                this.dataForm.type = data.advertisements.type
                this.dataForm.createTime = data.advertisements.createTime
                this.dataForm.createdUser = data.advertisements.createdUser
                this.dataForm.updateTime = data.advertisements.updateTime
                this.dataForm.updatedUser = data.advertisements.updatedUser
                this.dataForm.isDelete = data.advertisements.isDelete
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
              url: this.$http.adornUrl(`/advertisement/advertisements/${!this.dataForm.adId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'adId': this.dataForm.adId || undefined,
                'merchantId': this.dataForm.merchantId,
                'content': this.dataForm.content,
                'type': this.dataForm.type,
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
