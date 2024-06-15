<template>
  <div class="login-page">
    <h1>Login</h1>
    <LoginForm @submit="handleLogin" />
  </div>
</template>

<script>
import LoginForm from '../molecules/LoginForm.vue';

export default {
  components: {
    LoginForm,
  },
  methods: {
    handleLogin(credentials) {
      console.log('Login attempted with:', credentials);
      // Here you would typically handle the login logic, e.g., API call
    },
  },
};
</script>

<style scoped>
.login-page {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100vh;
}
</style>
