import axios from 'axios'

const state = {
    context: 'http://localhost:5000/',
    bugsmusic: []
}
const actions = {
    async search({commit}, searchWord) {
        alert('검색어:'+searchWord)
        axios.post(/*url1*/state.context+'bugsmusic',/*searchWord1*/searchWord, /*headers3*/{
            authoriazation: 'JWT fefege..', /* 1급객체 처리가 되어서 이렇게 될 수 있음 */
            Accept: 'application/json',
            'Content-type': 'application/json'
        })
            .then((data)=>{
                alert('검색된 결과수:'+data.count)
                commit('SEARCH', data) /* 갔다온다음, 왜 위 commit은 함수였는데 아래 함수는?? 키/값임 (매핑x, 안쪽에 또 함수를 넣은것) */
                /* a: binding - mutations에서*/
            })
            .catch(()=>{
                alert('통신실패')
            })
    }
}

const mutations = {
/*    SEARCH(state, data) { /!* 기능, 전부 state와 data를 가짐 *!/
        state.bugsmusic = [] /!*청소, 값비움*!/
        data.forEach(item => {
            alert(item)
            state.bugsmusic.push([])
        })
    }*/
}

const getters = {
    bugsmusic: state => state.bugsmusic /*매핑(값변동없음, 있으면 바인딩), 리턴값 있음*/
}

/* json 성질
* a : 'a', - 값
* b : b() - 키값*/

/* 자바스크립트 함수는 리턴값을 가짐 */
export default { /*default= Vuex, Vuex를 리턴하라*/
    name: 'crawling',
    namespaced: true, /*공간부여*/
    state,
    actions,
    mutations,
    getters
}