<template>
 <div id="app">
  <color-preview color="red"></color-preview>
  <color-preview color="blue"></color-preview>
</div>
</template>

<script>
export default {
components: 'color-preview', {
  template: '<div class="color-preview" :style="style"></div>',
  props: ['color'],
  computed: {
    style() {
      return { backgroundColor: this.color };
    }
  }
});
new Vue({
  el: '#app'
})
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
