import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App";
import { createGlobalStyle, ThemeProvider } from "styled-components";
import reset from "styled-reset";
import { Provider } from "react-redux";
import store from "./store/reducer";

const GlobalStyle = createGlobalStyle`
${reset}
:root{
  *{
    box-sizing: border-box;
  }
    a{ 
      text-decoration: none;
    }
    .disabled{
      opacity: 0.3;
      cursor: not-allowed !important;
    }
  }
`;

const root = ReactDOM.createRoot(document.getElementById("root"));

const colorThem = {
  footerBg: "#25262a",
  footerTitle: "hsl(210,8%,75%)",
  footerLink: "hsl(210,8%,60%)",
};

root.render(
  <Provider store={store}>
    <ThemeProvider theme={colorThem}>
      <GlobalStyle />
      <App />
    </ThemeProvider>
  </Provider>
);
