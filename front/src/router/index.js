import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Join from '../views/Join.vue'
import JoinIndv from '../views/JoinIndv.vue'
import JoinComp from '../views/JoinComp.vue'
import Login from '../views/Login.vue'
import LoginIndv from '../views/LoginIndv.vue'
import LoginComp from '../views/LoginComp.vue'
import Companies from '../views/Companies.vue'
import JobPosting from '../views/JobPosting.vue'
import RegisterPos from '../views/RegisterPos.vue'
import MyPageIndv from '../views/MyPageIndv.vue'
import MyPageComp from '../views/MyPageComp.vue'
import JobDetail from '../views/JobDetail.vue'
import ModifyPost from '../views/ModifyPost.vue'
import CompanyDetail from '../views/CompanyDetail.vue'
import Manager from '../views/Manager.vue'
import ManagerProgress from '../views/ManagerProgress.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/join',
    name: 'Join',
    component: Join
  },
  {
    path: '/join-indv',
    name: 'JoinIndv',
    component: JoinIndv
  },
  {
    path: '/join-comp',
    name: 'JoinComp',
    component: JoinComp
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/login-indv',
    name: 'LoginIndv',
    component: LoginIndv
  },
  {
    path: '/login-comp',
    name: 'LoginComp',
    component: LoginComp
  },
  {
    path: '/companies',
    name: 'Companies',
    component: Companies
  },
  {
    path: '/job-posting',
    name: 'JobPosting',
    component: JobPosting
  },
  {
    path: '/register-position',
    name: 'RegisterPos',
    component: RegisterPos
  },
  {
    path: '/mypage-indv',
    name: 'MyPageIndv',
    component: MyPageIndv
  },
  {
    path: '/mypage-comp',
    name: 'MyPageComp',
    component: MyPageComp
  },
  {
    path:'/job-detail',
    name:'JobDetail',
    component: JobDetail,
  },
  {
    path:'/job-detail/:params',
    name:'JobDetail',
    component: JobDetail,
  }, 
  {
    path:'/company-detail/',
    name:'CompanyDetail',
    component: CompanyDetail,
  },  
  {
    path:'/company-detail/:params',
    name:'CompanyDetail',
    component: CompanyDetail,
  },  
  {
    path:'/modify-post/',
    name:'ModifyPost',
    component: ModifyPost,
  },
  {
    path:'/modify-post/:params',
    name:'ModifyPost',
    component: ModifyPost,
  }, {
    path: '/Manager-Progress',
    name: 'ManagerProgress',
    component: ManagerProgress
  },
  {
    path: '/Manager-log',
    name: 'Manager',
    component: Manager
  }

]

const router = new VueRouter({
  routes
})

export default router
