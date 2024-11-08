import { createRouter, createWebHistory } from 'vue-router'
import IdolDetail from '@/components/IdolDetail.vue'
import IdolList from '@/components/IdolList.vue'
import IdolModify from '@/components/IdolModify.vue'
import IdolRegist from '@/components/IdolRegist.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/idoldetail',
      name: 'idoldetail',
      component: IdolDetail,
    },
    {
      path: '/idollist',
      name: 'idollist',
      component: IdolList, 
    },
    {
      path: '/idolmodify',
      name: 'idolmodify',
      component: IdolModify, 
    },
    {
      path: '/idolregist',
      name: 'idolregist',
      component: IdolRegist, 
    },

  ],
})

export default router
