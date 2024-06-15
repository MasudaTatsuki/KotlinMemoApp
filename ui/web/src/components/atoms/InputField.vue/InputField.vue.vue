<template>
  <input :type="type" :placeholder="placeholder" v-model="inputValue" />
</template>

<script>
export default {
  props: {
    type: {
      type: String,
      default: 'text',
    },
    placeholder: {
      type: String,
      default: '',
    },
  },
  data() {
    return {
      inputValue: '',
    };
  },
  watch: {
    inputValue(value) {
      this.$emit('input', value);
    },
  },
};
</script>

<style scoped>
input {
  padding: 10px;
  margin: 5px 0;
  width: 100%;
}
</style>
