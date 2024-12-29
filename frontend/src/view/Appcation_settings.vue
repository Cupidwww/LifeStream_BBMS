<template>
    <div class="settings-container">
        <el-card class="settings-card">
            <h1>Application Settings</h1>
            <p>This is the application settings page.</p>

            <!-- 用户偏好设置 -->
            <el-divider content-position="left">User Preferences</el-divider>
            <el-form label-width="150px">
                <el-form-item label="Enable Notifications">
                    <el-switch v-model="preferences.notifications" />
                </el-form-item>
                <el-form-item label="Enable Dark Mode">
                    <el-switch v-model="preferences.darkMode" />
                </el-form-item>
            </el-form>

            <!-- 主题切换 -->
            <el-divider content-position="left">Theme</el-divider>
            <el-form label-width="150px">
                <el-form-item label="Select Theme">
                    <el-select v-model="selectedTheme" placeholder="Choose a theme">
                        <el-option label="Light Theme" value="light" />
                        <el-option label="Dark Theme" value="dark" />
                        <el-option label="Blue Theme" value="blue" />
                    </el-select>
                </el-form-item>
            </el-form>

            <!-- 保存按钮 -->
            <el-button type="primary" @click="saveSettings" class="save-button">Save Settings</el-button>
        </el-card>
    </div>
</template>

<script>
import { mapState, mapActions } from 'vuex';

export default {
    data() {
        return {
            preferences: {
                notifications: true,
                darkMode: false
            }
        };
    },
    computed: {
        ...mapState(['selectedTheme']),
        selectedTheme: {
            get() {
                return this.$store.state.selectedTheme;
            },
            set(value) {
                this.updateTheme(value);
            }
        }
    },
    methods: {
        ...mapActions(['updateTheme']),
        saveSettings() {
            // 保存设置到 localStorage
            localStorage.setItem('userSettings', JSON.stringify({
                preferences: this.preferences,
                selectedTheme: this.selectedTheme
            }));
            this.$message.success('Settings saved successfully!');
        }
    }
};
</script>

<style scoped>
.settings-container {
    padding: 20px;
    max-width: 800px;
    margin: 0 auto;
}

.settings-card {
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}

h1 {
    font-size: 24px;
    margin-bottom: 10px;
}

p {
    font-size: 14px;
    color: #666;
    margin-bottom: 20px;
}

.save-button {
    margin-top: 20px;
    width: 100%;
}
</style>
