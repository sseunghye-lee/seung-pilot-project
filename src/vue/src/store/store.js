import Vuex from 'vuex';
import Vue from 'vue';

Vue.use(Vuex);

export const store = new Vuex.Store({
    state: {
        token: null,
    },
    getters: {
        isLogin(state) {
            return state.token == null ? false : true;
        },
        mutations: {
            setToken(state, _token) {
                state.token = _token;
            }
        },
        actions: {
            setToken: ({commit}, _token) => {
                commit('setToken', _token);
            }
        }
    }
})