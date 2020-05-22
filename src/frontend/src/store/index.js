import Vue from 'vue'
import Vuex from 'vuex'
import crawler from './crawler'

Vue.use(Vuex)
export const store = new Vuex.Store({
    modules: {
        crawler
    }
})