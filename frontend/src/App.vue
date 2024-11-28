<template>
  <div id="app">
    <!-- <PageLayout /> 加载布局 -->
    <router-view /> 
  </div>
</template>

<script>
// import PageDesignVue from './components/PageDesign.vue'
// import PageLayout from './layouts/PageLayout.vue'

export default {
  name: 'App',
  components: {
    // PageLayout
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>
