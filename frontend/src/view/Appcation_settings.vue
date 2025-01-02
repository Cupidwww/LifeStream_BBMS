<template>
  <main class="settings-main">
    <div class="settings-header">
      <h1 class="header-title">User Settings</h1>
      <el-icon class="header-icon"><User /></el-icon>
    </div>

    <div class="settings-content">
      <!-- 个人信息 -->
      <section class="settings-section">
        <h2 class="section-title">Personal Information</h2>
        <el-form label-width="140px" class="form-container">
          <el-form-item label="avatar">
            <el-upload
              action="https://jsonplaceholder.typicode.com/posts/"
              list-type="picture-card"
              :on-preview="handleAvatarPreview"
              :on-remove="handleAvatarRemove"
            >
              <el-icon><Plus /></el-icon>
            </el-upload>
          </el-form-item>
          <el-form-item label="username">
            <el-input v-model="form.nickname" placeholder="please enter your username" />
          </el-form-item>
          <el-form-item label="biography">
            <el-input
              v-model="form.bio"
              type="textarea"
              placeholder="please enter your biography"
            />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" size="large" @click="saveProfile"
              >save</el-button
            >
          </el-form-item>
        </el-form>
      </section>

      <!-- 账户安全 -->
      <section class="settings-section">
        <h2 class="section-title">Account Security</h2>
        <el-form label-width="140px" class="form-container">
          <el-form-item label="Modify Password">
            <el-input
              v-model="form.password"
              type="password"
              placeholder="please enter your new password"
            />
          </el-form-item>
          <el-form-item label="Two-factor authentication">
            <el-switch v-model="form.twoFactorAuth" />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" size="large" @click="saveSecurity"
              >save</el-button
            >
          </el-form-item>
        </el-form>
      </section>

      <!-- 通知设置 -->
      <section class="settings-section">
        <h2 class="section-title">Notification Settings</h2>
        <el-form label-width="140px" class="form-container">
          <el-form-item label="accept email notifications">
            <el-switch v-model="form.emailNotifications" />
          </el-form-item>
          <el-form-item label="accept SMS notifications">
            <el-switch v-model="form.smsNotifications" />
          </el-form-item>
          <el-form-item>
            <el-button type="primary" size="large" @click="saveNotifications"
              >save</el-button
            >
          </el-form-item>
        </el-form>
      </section>
    </div>
  </main>
</template>

<script setup>
import { ref } from 'vue';
// import { Plus, User } from '@element-plus/icons-vue';


const form = ref({
  nickname: '',
  bio: '',
  password: '',
  twoFactorAuth: false,
  emailNotifications: true,
  smsNotifications: false,
});

const handleAvatarPreview = (file) => {
  console.log('预览头像', file);
};

const handleAvatarRemove = (file) => {
  console.log('移除头像', file);
};

const saveProfile = () => {
  console.log('保存个人信息', form.value);
};

const saveSecurity = () => {
  console.log('保存账户安全设置', form.value);
};

const saveNotifications = () => {
  console.log('保存通知设置', form.value);
};
</script>

<style scoped>
.settings-main {
  padding: 40px;
  background: linear-gradient(135deg, #f5f7fa, #c3cfe2);
  min-height: 100vh;
}

.settings-header {
  display: flex;
  align-items: center;
  margin-bottom: 40px;
}

.header-title {
  font-size: 32px;
  font-weight: bold;
  color: #303133;
  margin-right: 16px;
}

.header-icon {
  font-size: 36px;
  color: #409eff;
}

.settings-content {
  max-width: 800px;
  margin: 0 auto;
}

.settings-section {
  background: #ffffff;
  border-radius: 12px;
  box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
  padding: 24px;
  margin-bottom: 24px;
}

.section-title {
  font-size: 24px;
  font-weight: bold;
  color: #303133;
  margin-bottom: 24px;
}

.form-container {
  padding: 16px;
}

.el-form-item {
  margin-bottom: 24px;
}

.el-input,
.el-textarea {
  width: 100%;
}

.el-button {
  width: 120px;
}
</style>
