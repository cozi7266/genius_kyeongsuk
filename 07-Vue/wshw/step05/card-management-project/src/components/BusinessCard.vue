<template>
    <div class="card-container">
      <BusinessCardDetail
        v-for="(card, index) in cards"
        :key="index"
        :card="card"
        @delete-card-event="deleteCard"
      />
    </div>
  </template>
  
  <script setup>
  import { ref } from 'vue';
  import BusinessCardDetail from './BusinessCardDetail.vue';
  
  const emits = defineEmits(['send-count']);
  

  const cards = ref([
    { name: "일론 머스크", title: "테슬라 테크노 킹" },
    { name: "래리 엘리슨", title: "오라클 창업주" },
    { name: "빌 게이츠", title: "마이크로소프트 공동창업주" },
    { name: "래리 페이지", title: "구글 공동창업주" },
    { name: "세르게이 브린", title: "구글 공동창업주" }
  ]);
  
 
  
  
  
  const deleteCard = (targetCard) => {
    const index = cards.value.findIndex(
      (card) => card.name === targetCard.name && card.title === targetCard.title
    );
    if (index !== -1) {
      cards.value.splice(index, 1);
      emits('send-count', cards.value.length);
    }
  };
  </script>
  
  <style scoped>
  .card-container {
    display: flex;
    flex-wrap: wrap;
    gap: 20px;
    justify-content: center;
  }
  </style>
  