import React from "react";
import styled from "styled-components";

const Container = styled.div`
  box-sizing: border-box;
  width: 100%;
  max-width: 1215px;
  margin: 0 auto;
`;

export default function LayoutContainer({ children }) {
  return <Container>{children}</Container>;
}
