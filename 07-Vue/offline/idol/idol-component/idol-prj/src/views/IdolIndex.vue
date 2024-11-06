<script setup>
import { ref } from "vue";


import IdolList from "@/components/IdolList.vue";
import IdolDetail from "@/components/IdolDetail.vue";
import IdolRegist from "@/components/IdolRegist.vue";
import IdolModify from "@/components/IdolModify.vue";

// 현재 뷰를 관리하는 상태 정의
const currentView = ref("list");
const no = ref(0);

// detail 뷰로 전환하는 함수
const doDetailView = (idolNo) => {
    no.value = idolNo;
    currentView.value = "detail"; // currentView를 'detail'로 업데이트
};

const doListView = () => {
    currentView.value = "list"
}

const insertFormView = () => {
    currentView.value = "register"
}

const doModifyView = (idolNo) => {
    currentView.value = "modify"
    no.value = idolNo;
}
</script>

<template>
  <div>
    <IdolList @detailView="doDetailView" @insertView="insertFormView" v-if="currentView === 'list'"></IdolList>
    
    <IdolDetail @listView="doListView" @modifyView="doModifyView" v-if="currentView === 'detail'" :no="no"></IdolDetail>

    <IdolRegist v-if="currentView === 'register'"></IdolRegist>

    <IdolModify v-if="currentView === 'modify'" :no="no"></IdolModify>
  </div>
</template>

<style scoped></style>
