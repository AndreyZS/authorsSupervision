import Vuex, {createStore} from 'vuex';
import Vue from 'vue';
import createPersistedState from "vuex-persistedstate";
import {AuthModule} from './AuthModule';

// Load Vuex
// Create store
export default new createStore({
    modules: {
        AuthModule
    },
    plugins: [createPersistedState()]
});
