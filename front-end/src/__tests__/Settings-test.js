'use strict';

import React from 'react';
import Settings from '../js/components/Settings.jsx';
import renderer from 'react-test-renderer';

describe('Settings', () => {

  it('renders correctly', () => {
    const tree = renderer.create(
      <Settings />
    ).toJSON();
    expect(tree).toMatchSnapshot();
  });
});