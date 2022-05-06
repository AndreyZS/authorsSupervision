<template>
  <div>
    <div class="title">
      <h1>Авторизация</h1>
    </div>
    <div class="container">
      <div class="left"></div>
      <div class="right">
        <div class="formBox">
          <div>
            <p>Логин</p>
            <input :value="login" @input="event => login = event.target.value" type="text" name="" placeholder="Login">
            <p>Пароль</p>
            <input :value="password" @input="event => password = event.target.value" type="password" name="" placeholder="****">
            <button  @click="this.test">Войти</button>
            <a href="#">Регистрация</a>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  props:{
    login:"",
    password:""
  },
  methods:{
    test(){
      this.$store.dispatch('AuthModule/onLogin',{
        login: this.login,
        password: this.password
      })
      alert(this.login+" "+this.password)
    }
  }

}
</script>

<style scoped>


.title {
  text-align: center;
  padding: 50px 0 20px;
}

.title h1 {
  margin: 0;
  padding: 0;
  color: #262626;
  text-transform: uppercase;
  font-size: 36px;
}

.container {
  width: 50%;
  height: 400px;
  background: #fff;
  margin: 0 auto;
  border: 2px solid #fff;
  box-shadow: 0 15px 40px rgba(0, 0, 0, .5);
}

.container .left {
  float: left;
  width: 50%;
  height: 400px;
  background: url("https://img4.goodfon.ru/original/1680x1050/b/1f/nebo-bashennyi-kran-kran-stroika.jpg");
  background-size: cover;
  box-sizing: border-box;
}

.container .right {
  float: right;
  width: 50%;
  height: 400px;
  box-sizing: border-box;
}

.formBox {
  width: 100%;
  padding: 80px 40px;
  box-sizing: border-box;
  height: 400px;
  background: #fff;

}

.formBox p {
  margin: 0;
  padding: 0;
  font-weight: bold;
  color: #a6af13;
}

.formBox input {
  width: 100%;
  margin-bottom: 20px;
  border: none;
  border-bottom: 2px solid #a6af13;
  outline: none;
  height: 40px;
}

.formBox input:focus {
  margin-bottom: 20px;
  border-bottom: 2px solid #262626;
}

.formBox button{
  width: 100%;
  border: none;
  outline: none;
  height: 40px;
  color: #fff;
  background: #262626;
  cursor: pointer;
}
.formBox button:hover{
  background: #a6af13;
}
</style>