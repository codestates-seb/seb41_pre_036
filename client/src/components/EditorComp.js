import React from "react";
import styled from "styled-components";
import MDEditor from "@uiw/react-md-editor";
import rehypeSanitize from "rehype-sanitize";

document.documentElement.setAttribute("data-color-mode", "light");

const Container = styled.div`
  /* height: 500px; */
  border: 1px solid transparent;
  border-radius: 5px;
  .w-md-editor {
    border: 1px solid #d0d7de;
    box-shadow: none;
    &:focus-within {
      border-color: #6bbbf7;
      box-shadow: 0 0 0 4px #cce9fe, 0 0 0 4px #cce9fe;
    }
  }
`;

function EditorComp({ value, onChange }) {
  return (
    <Container>
      <MDEditor
        value={value}
        onChange={onChange}
        previewOptions={{
          rehypePlugins: [[rehypeSanitize]],
        }}
        height={250}
      />
    </Container>
  );
}

export default EditorComp;
