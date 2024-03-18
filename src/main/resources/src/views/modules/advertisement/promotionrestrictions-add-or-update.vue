<template>
  <el-dialog
    :title="!dataForm.id ? '新增' : '修改'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <el-form-item label="学院ID" prop="collegeId">
      <el-input v-model="dataForm.collegeId" placeholder="学院ID"></el-input>
    </el-form-item>
    <el-form-item label="来源地" prop="origin">
      <el-input v-model="dataForm.origin" placeholder="来源地"></el-input>
    </el-form-item>
    <el-form-item label="性别" prop="gender">
      <el-input v-model="dataForm.gender" placeholder="性别"></el-input>
    </el-form-item>
    <el-form-item label="计划ID" prop="planId">
      <el-input v-model="dataForm.planId" placeholder="计划ID"></el-input>
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
          restrictionId: 0,
          collegeId: '',
          origin: '',
          gender: '',
          planId: '',
          createTime: '',
          createdUser: '',
          updateTime: '',
          updatedUser: '',
          isDelete: ''
        },
        dataRule: {
          collegeId: [
            { required: true, message: '学院ID不能为空', trigger: 'blur' }
          ],
          origin: [
            { required: true, message: '来源地不能为空', trigger: 'blur' }
          ],
          gender: [
            { required: true, message: '性别不能为空', trigger: 'blur' }
          ],
          planId: [
            { required: true, message: '计划ID不能为空', trigger: 'blur' }
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
        this.dataForm.restrictionId = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.restrictionId) {
            this.$http({
              url: this.$http.adornUrl(`/advertisement/promotionrestrictions/info/${this.dataForm.restrictionId}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.collegeId = data.promotionRestrictions.collegeId
                this.dataForm.origin = data.promotionRestrictions.origin
                this.dataForm.gender = data.promotionRestrictions.gender
                this.dataForm.planId = data.promotionRestrictions.planId
                this.dataForm.createTime = data.promotionRestrictions.createTime
                this.dataForm.createdUser = data.promotionRestrictions.createdUser
                this.dataForm.updateTime = data.promotionRestrictions.updateTime
                this.dataForm.updatedUser = data.promotionRestrictions.updatedUser
                this.dataForm.isDelete = data.promotionRestrictions.isDelete
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
              url: this.$http.adornUrl(`/advertisement/promotionrestrictions/${!this.dataForm.restrictionId ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'restrictionId': this.dataForm.restrictionId || undefined,
                'collegeId': this.dataForm.collegeId,
                'origin': this.dataForm.origin,
                'gender': this.dataForm.gender,
                'planId': this.dataForm.planId,
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
