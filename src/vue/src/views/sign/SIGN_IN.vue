<template>
    <div class="sign">
        <div class="sign-in">
            <div><img src="~@/assets/img/main_0duck.jpeg" alt="" class="logo">
            </div>
            <div>
                <el-input v-model="loginRequest.email" ref="loginEmail"
                          @keyup.enter="this.$refs.loginPw.focus()" size="large"
                          placeholder="아이디를 입력하세요." maxlength="40" @keypress="noSpace($event)"
                          class="sign-input/v/sign/out"/>
            </div>
            <div class="failMsg">
                <span v-show="this.emptyString.userEmail" style="color: red;">아이디를 입력하세요.</span>
            </div>

            <div>
                <el-input v-model="loginRequest.password" ref="loginPw"
                          @keyup.enter="this.onclickLogin" size="large" show-password
                          type="password" maxlength="16" @keypress="noSpace($event)" placeholder="비밀번호를 입력하세요." class="sign-input"/>
                <div class="failMsg">
                    <span v-show="this.emptyString.password" style="color: red;">비밀번호를 입력하세요.</span>
                </div>
            </div>
            <div class="sign-in-text">
                <el-checkbox v-model="loginRequest.remember" label="로그인 상태 유지"
                             size="small"></el-checkbox>
            </div>
            <div class=sign-text>
                <el-alert v-if="msg" :title="msg" type="warning" :closable="false"></el-alert>
            </div>
            <div class="bottom-confirm-btn">
                <el-button @click="onclickLogin" type="info" size="large"
                           class="el-button el-button--large el-btn-primary" style="width:100%;">로그인
                </el-button>
            </div>
            <!--            <div class="bottom-confirm-btn">-->
            <!--                <el-button @click="onclickSerial" type="info" size="large"-->
            <!--                           class="el-button el-button&#45;&#45;large el-btn-primary" style="width:100%;">시리얼 로그인-->
            <!--                </el-button>-->
            <!--            </div>-->
        </div>
    </div>

</template>

<script src="./SIGN_IN.js">
</script>

<style lang="scss" scoped>

</style>
