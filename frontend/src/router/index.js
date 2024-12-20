import { Avatar, Bell, Grid, HomeFilled, List, Management, Tools } from '@element-plus/icons-vue';
import { createRouter, createWebHistory } from 'vue-router';

import AuthLayout from '@/layouts/AuthLayout.vue';
import PageLayout from '@/layouts/PageLayout.vue';

const routes = [
    {
        path: '/',
        redirect: '/home',
    },
    {
        path: '/home',
        name: 'Home',
        component: () => import('@/view/Personal_homepage.vue'),
        meta: { title: 'Personal homepage', icon: HomeFilled, layout: PageLayout },
    },
    // {
    //     path: '/blood-donation',
    //     name: 'BloodDonation',
    //     component: () => import('@/view/Blood_donation.vue'),
    //     meta: { title: 'Blood donation', icon: Calendar, layout: PageLayout },
    // },
    {
        path: '/blood-record',
        name: 'BloodRecord',
        component: () => import('@/view/Blood_record_management.vue'),
        meta: { title: 'Blood Record Management', icon: Management, layout: PageLayout },
    },
    {
        path: '/health-info',
        name: 'HealthInfo',
        component: () => import('@/view/Health_information_management.vue'),
        meta: { title: 'Health Information Management', icon: List, layout: PageLayout },
    },
    {
        path: '/user-management',
        name: 'UserManagement',
        meta: { title: 'User management', icon: Avatar, layout: PageLayout },
        children: [
            {
                path: 'donor',
                name: 'Donor',
                component: () => import('@/view/UserManagement/DonorManagement.vue'),
                meta: { title: 'Donor', layout: PageLayout },
            },
            {
                path: 'staff',
                name: 'Staff',
                component: () => import('@/view/UserManagement/StaffManagement.vue'),
                meta: { title: 'Staff', layout: PageLayout },
            },
        ],
    },
    {
        path: '/blood-bank',
        name: 'BloodBank',
        meta: { title: 'Blood bank', icon: Grid, layout: PageLayout },
        children: [
            {
                path: 'query',
                name: 'Query',
                component: () => import('@/view/BloodBank/BloodQuery.vue'),
                meta: { title: 'Query', layout: PageLayout },
            },
            // {
            //     path: 'inbound',
            //     name: 'Inbound',
            //     component: () => import('@/view/BloodBank/BloodInbound.vue'),
            //     meta: { title: 'Inbound', layout: PageLayout },
            // },
            // {
            //     path: 'outbound',
            //     name: 'Outbound',
            //     component: () => import('@/view/BloodBank/BloodOutbound.vue'),
            //     meta: { title: 'Outbound', layout: PageLayout },
            // },
        ],
    },
    // {
    //     path: '/message',
    //     name: 'Message',
    //     component: () => import('@/view/Message_notification.vue'),
    //     meta: { title: 'Message', icon: Bell, layout: PageLayout },
    // },
    {
        path: '/settings',
        name: 'Settings',
        component: () => import('@/view/Appcation_settings.vue'),
        meta: { title: 'Setting', icon: Tools, layout: PageLayout },
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import('@/view/UserLogin.vue'),
        meta: { layout: AuthLayout },
    },
    {
        path: '/register',
        name: 'Register',
        component: () => import('@/view/UserRegister.vue'),
        meta: { layout: AuthLayout },
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});

export default router;
