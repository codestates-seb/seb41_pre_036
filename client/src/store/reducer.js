import { configureStore, createSlice } from "@reduxjs/toolkit";

// const initialToken = localStorage.getItem('accessToken');
const initialState = {
  isLogin: false,
  //   accessToken: initialToken,
};

const loginStore = createSlice({
  name: "isLogin",
  initialState,
  reducers: {
    login: (state) => {
      state.isLogin = true;
    },
    logout: (state) => {
      state.isLogin = false;
    },
  },
});

const store = configureStore({
  reducer: loginStore.reducer,
});

export const { login, logout } = loginStore.actions;

export default store;
