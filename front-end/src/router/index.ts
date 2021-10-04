import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import HomePage from "../views/HomePage.vue"
import LoginPage from "../views/LoginPage.vue"
import RegisterPage from "../views/RegisterPage.vue"

const routes: Array<RouteRecordRaw> = [
    {
        path: "/",
        name: "HomePage",
        component: HomePage,
    },
    {
        path: "/login",
        name: "LoginPage",
        component: LoginPage,
    },
    {
        path: "/register",
        name: "RegisterPage",
        component: RegisterPage,
    }
];

const router = createRouter({
    // history: createWebHistory(process.env.BASE_URL),
    history: createWebHistory(),
    routes,
});

export default router;