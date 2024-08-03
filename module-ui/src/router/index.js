import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: () => import('../views/LoginView.vue')
  },
  {
    path: '/admin',
    name: 'admin',
    redirect: '/front1',
    component: () => import('../views/AdminView.vue'),
    children:[
      {
        path: '/front1',
        name: 'front1',
        component: () => import('../components/front1.vue'),
      },{
        path: '/front2',
        name: 'front2',
        component: () => import('../components/front2.vue'),
      }
    ]
  },{
    path: '/user',
    name: 'user',
    redirect: '/u1',
    component: () => import('../views/UserView.vue'),
    children:[
      {
        path: '/u1',
        name: 'u1',
        component: () => import('../components/u1.vue'),
      }
    ]
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
